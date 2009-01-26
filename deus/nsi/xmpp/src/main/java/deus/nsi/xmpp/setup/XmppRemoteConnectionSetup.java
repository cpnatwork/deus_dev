package deus.nsi.xmpp.setup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.User;
import deus.model.user.transportid.TransportIdType;
import deus.nsi.xmpp.common.XmppConversation;
import deus.nsi.xmpp.common.XmppNetwork;
import deus.nsi.xmpp.common.XmppSkeleton;
import deus.nsi.xmpp.publisher.impl.skeleton.XmppPublisherSkeleton;
import deus.nsi.xmpp.publisher.impl.skeleton.packetlistener.SubscribePacketListener;
import deus.nsi.xmpp.publisher.impl.skeleton.packetlistener.UnsubscribePacketListener;
import deus.nsi.xmpp.subscriber.impl.skeleton.XmppSubscriberSkeleton;
import deus.nsi.xmpp.subscriber.impl.skeleton.packetlistener.UpdatePacketListener;
import deus.remoting.setup.RemoteConnectionSetup;
import deus.remoting.state.RemotingStateRegistry;

@Component
public class XmppRemoteConnectionSetup implements RemoteConnectionSetup {

	@Autowired
	private XmppNetwork xmppNetwork;

	@Override
	public void setUp(User user) {
		if(user.getRemotingStateRegistry().hasRemotingState(TransportIdType.xmpp))
			throw new IllegalStateException("Can't setup remoting, it has already been setup!");
		
		
		// TODO: get password out of user
		// 
		XmppConversation xmppConversation = xmppNetwork.createConversation(user.getUserMetadata(), "test");
		XmppRemotingState remotingState = new XmppRemotingState(xmppConversation);
		
		// CONNECT
		xmppConversation.connect();
		
		// ADD SKELETONS
		addSkeletons(remotingState, xmppConversation, user);
		
		// LOGIN
		xmppConversation.login();
		
		// ADD REMOTING STATE
		user.getRemotingStateRegistry().addRemotingState(TransportIdType.xmpp, remotingState);
	}
	

	// TODO: refactor
	private void addSkeletons(XmppRemotingState remotingState, XmppConversation xmppConversation, User user) {
		// add publisher skeleton
		XmppPublisherSkeleton xmppPublisherSkeleton = new XmppPublisherSkeleton(xmppConversation);
		
		SubscribePacketListener subscribePacketListener = new SubscribePacketListener();
		subscribePacketListener.setRemoteCalledPublisher(user.getPublisher());
		xmppPublisherSkeleton.addPacketListener(subscribePacketListener);
		
		UnsubscribePacketListener unsubscribePacketListener = new UnsubscribePacketListener();
		unsubscribePacketListener.setRemoteCalledPublisher(user.getPublisher());
		xmppPublisherSkeleton.addPacketListener(unsubscribePacketListener);		
		
		xmppPublisherSkeleton.connect();
		remotingState.setXmppPublisherSkeleton(xmppPublisherSkeleton);

		
		// add subscriber skeleton
		XmppSubscriberSkeleton xmppSubscriberSkeleton = new XmppSubscriberSkeleton(xmppConversation);
				
		UpdatePacketListener updatePacketListener = new UpdatePacketListener();
		updatePacketListener.setRemoteCalledSubscriber(user.getSubscriber());		
		xmppSubscriberSkeleton.addPacketListener(updatePacketListener);		
		
		xmppSubscriberSkeleton.connect();
		remotingState.setXmppSubscriberSkeleton(xmppSubscriberSkeleton);
	}

	
	@Override
	public void tearDown(User user) {
		XmppRemotingState remotingState = (XmppRemotingState)user.getRemotingStateRegistry().getRemotingState(TransportIdType.xmpp);
		if(!remotingState.isRemotingAvailable())
			throw new IllegalStateException("can't tear down remoting, it is not setup!");
		
		remotingState.getXmppConversation().end();
		
		XmppSkeleton publisherSkeleton = remotingState.getXmppPublisherSkeleton();
		publisherSkeleton.disconnect();
		remotingState.removeXmppPublisherSkeleton();

		XmppSkeleton subscriberSkeleton = remotingState.getXmppSubscriberSkeleton();
		subscriberSkeleton.disconnect();
		remotingState.removeXmppSubscriberSkeleton();
		
		user.getRemotingStateRegistry().removeRemotingState(TransportIdType.xmpp);
	}

}

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
import deus.remoting.setup.impl.AbstractRemoteConnectionSetup;
import deus.remoting.state.RemotingStateRegistry;

// FIXME: think about refactoring some of the stuff of this methods to abstract super class!
@Component
public class XmppRemoteConnectionSetup extends AbstractRemoteConnectionSetup {

	@Autowired
	private XmppNetwork xmppNetwork;

	@Override
	public void checkedSetUp(User user) {

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
		user.getRemotingStateRegistry().addRemotingState(getType(), remotingState);
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
	public void checkedTearDown(User user) {
		RemotingStateRegistry remotingStateRegistry = user.getRemotingStateRegistry();
		XmppRemotingState remotingState = (XmppRemotingState)remotingStateRegistry.getRemotingState(getType());
		
		remotingState.getXmppConversation().end();
		
		XmppSkeleton publisherSkeleton = remotingState.getXmppPublisherSkeleton();
		publisherSkeleton.disconnect();
		remotingState.removeXmppPublisherSkeleton();

		XmppSkeleton subscriberSkeleton = remotingState.getXmppSubscriberSkeleton();
		subscriberSkeleton.disconnect();
		remotingState.removeXmppSubscriberSkeleton();
		
		remotingStateRegistry.removeRemotingState(getType());
	}


	@Override
	public TransportIdType getType() {
		return TransportIdType.xmpp;
	}

}

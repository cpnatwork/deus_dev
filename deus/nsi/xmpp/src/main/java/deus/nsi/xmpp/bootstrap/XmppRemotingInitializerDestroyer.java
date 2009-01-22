package deus.nsi.xmpp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.User;
import deus.model.user.id.transportid.TransportIdType;
import deus.nsi.xmpp.common.XmppConversation;
import deus.nsi.xmpp.common.XmppNetwork;
import deus.nsi.xmpp.common.XmppSkeleton;
import deus.nsi.xmpp.publisher.impl.skeleton.XmppPublisherSkeleton;
import deus.nsi.xmpp.subscriber.impl.skeleton.XmppSubscriberSkeleton;
import deus.remoting.initializerdestroyer.RemotingInitializerDestroyer;

@Component
public class XmppRemotingInitializerDestroyer implements RemotingInitializerDestroyer {

	@Autowired
	private XmppNetwork xmppNetwork;

	@Override
	public void setUp(User user) {
		XmppRemotingState remotingState = (XmppRemotingState)user.getRemotingState(TransportIdType.xmpp);
		if(remotingState.isRemotingAvailable())
			throw new IllegalStateException("Can't setup remoting, it has already been setup!");
		
		// TODO: get password out of user
		XmppConversation xmppConversation = xmppNetwork.login(user.getUserMetadata(), "test");

		addSkeletons(remotingState, xmppConversation);
				
		xmppConversation.start();
	}


	private void addSkeletons(XmppRemotingState remotingState, XmppConversation xmppConversation) {
		// add publisher skeleton
		XmppPublisherSkeleton xmppPublisherSkeleton = new XmppPublisherSkeleton(xmppConversation);
		xmppPublisherSkeleton.connect();
		remotingState.setXmppPublisherSkeleton(xmppPublisherSkeleton);
		// add subscriber skeleton
		XmppSubscriberSkeleton xmppSubscriberSkeleton = new XmppSubscriberSkeleton(xmppConversation);
		xmppSubscriberSkeleton.connect();
		remotingState.setXmppSubscriberSkeleton(xmppSubscriberSkeleton);
	}

	
	@Override
	public void tearDown(User user) {
		XmppRemotingState remotingState = (XmppRemotingState)user.getRemotingState(TransportIdType.xmpp);
		if(!remotingState.isRemotingAvailable())
			throw new IllegalStateException("can't tear down remoting, it is not setup!");
		
		remotingState.getXmppConversation().end();
		
		XmppSkeleton publisherSkeleton = remotingState.getXmppPublisherSkeleton();
		publisherSkeleton.disconnect();
		remotingState.removeXmppPublisherSkeleton();

		XmppSkeleton subscriberSkeleton = remotingState.getXmppSubscriberSkeleton();
		subscriberSkeleton.disconnect();
		remotingState.removeXmppSubscriberSkeleton();
	}

}

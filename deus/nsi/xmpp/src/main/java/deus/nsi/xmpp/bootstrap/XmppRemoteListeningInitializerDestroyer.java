package deus.nsi.xmpp.bootstrap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.User;
import deus.model.user.id.UserIdType;
import deus.nsi.xmpp.common.XmppSkeleton;
import deus.nsi.xmpp.publisher.impl.skeleton.XmppPublisherSkeleton;
import deus.nsi.xmpp.subscriber.impl.skeleton.XmppSubscriberSkeleton;
import deus.remoting.initializerdestroyer.RemoteListeningInitializerDestroyer;
import deus.remoting.initializerdestroyer.RemotingState;
import deus.remoting.initializerdestroyer.RemotingStateRegistry;

@Component
public class XmppRemoteListeningInitializerDestroyer implements RemoteListeningInitializerDestroyer {

	@Autowired
	private RemotingStateRegistry remotingStateRegistry;


	@Override
	public void setUp(User user) {
		// SET UP PUBLISHER SKELETON
		XmppRemotingState remotingState = getRemotingState(user);

		setUpSkeleton(new XmppPublisherSkeleton(remotingState.getXmppConversation()), remotingState);
		setUpSkeleton(new XmppSubscriberSkeleton(remotingState.getXmppConversation()), remotingState);
	}


	private void setUpSkeleton(XmppSkeleton skeleton, XmppRemotingState remotingState) {
		skeleton.connect();
		remotingState.addConnectedXmppSkeleton(skeleton);
	}


	// TODO: externalize this method into superclass or helper
	private XmppRemotingState getRemotingState(User user) {
		RemotingState remotingState = remotingStateRegistry.getRemotingState(user);

		if (!remotingState.getUserIdType().equals(UserIdType.xmpp))
			throw new RuntimeException("cannot tear down remoting for user " + user + " since the stored"
					+ "remoting state for this user is not of type XmppRemoting, but of type "
					+ remotingState.getClass());

		return (XmppRemotingState) remotingState;
	}


	@Override
	public void tearDown(User user) {
		XmppRemotingState remotingState = getRemotingState(user);
		List<XmppSkeleton> connectedXmppSkeletons = remotingState.getAllConnectedXmppSkeletons();
		for (XmppSkeleton skeleton : connectedXmppSkeletons)
			skeleton.disconnect();

		remotingState.clearSkeletonList();
	}

}

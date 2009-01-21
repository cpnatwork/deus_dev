package deus.nsi.xmpp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.User;
import deus.model.user.id.UserIdType;
import deus.nsi.xmpp.common.XmppConversation;
import deus.nsi.xmpp.common.XmppNetwork;
import deus.remoting.initializerdestroyer.RemotingInitializerDestroyer;
import deus.remoting.initializerdestroyer.RemotingState;
import deus.remoting.initializerdestroyer.RemotingStateRegistry;

@Component
public class XmppRemotingInitializerDestroyer implements RemotingInitializerDestroyer {

	@Autowired
	private XmppNetwork xmppNetwork;

	@Autowired
	private RemotingStateRegistry remotingStateRegistry;


	@Override
	public void setUp(User user) {
		// TODO: get password somehow out of user
		if(remotingStateRegistry.hasRemotingState(user))
			throw new RuntimeException("there is already a remoting state registered for the user " + user);
		
		XmppConversation xmppConversation = xmppNetwork.login(user.getUserMetadata(), "test");

		// TODO: add packetListeners (skeletons here!)
		
		xmppConversation.start();
		
		RemotingState userRemotingState = new XmppRemotingState(xmppConversation);

		remotingStateRegistry.addRemotingState(user, userRemotingState);
	}


	private XmppRemotingState getRemotingState(User user) {
		if (!remotingStateRegistry.hasRemotingState(user))
			throw new RuntimeException("no remoting state available for user " + user
					+ ". Maybe, the user has no RemotingState, since remoting is not available yet?");
		RemotingState remotingState = remotingStateRegistry.getRemotingState(user);

		if (!remotingState.getUserIdType().equals(UserIdType.xmpp))
			throw new RuntimeException("cannot tear down remoting for user " + user + " since the stored"
					+ "remoting state for this user is not of type XmppRemoting, but of type "
					+ remotingState.getClass());
		
		return (XmppRemotingState)remotingState;
	}
	
	
	@Override
	public void tearDown(User user) {
		XmppRemotingState remotingState = getRemotingState(user);
		remotingState.getXmppConversation().end();

		// remove remoting state
		remotingStateRegistry.removeRemotingState(user);
	}

}

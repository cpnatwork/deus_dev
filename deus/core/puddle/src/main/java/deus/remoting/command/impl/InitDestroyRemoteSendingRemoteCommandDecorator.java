package deus.remoting.command.impl;

import java.util.Map;

import deus.core.User;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.setup.RemoteSendingSetup;
import deus.remoting.state.RemotingState;

public class InitDestroyRemoteSendingRemoteCommandDecorator extends AbstractRemoteCommandDecorator {

	private Map<TransportIdType, RemoteSendingSetup> remoteSendingInitializerDestroyers;

	private final User user;

	public InitDestroyRemoteSendingRemoteCommandDecorator(User user) {
		this.user = user;
	}


	@Override
	public void beforeExecute(RemotingState remotingState) {
		RemoteSendingSetup initializer = remoteSendingInitializerDestroyers.get(remotingState.getType());
		initializer.setUp(user);
	}


	@Override
	public void afterExecute(RemotingState remotingState) {
		RemoteSendingSetup destroyer = remoteSendingInitializerDestroyers.get(remotingState.getType());
		destroyer.tearDown(user);
	}

}

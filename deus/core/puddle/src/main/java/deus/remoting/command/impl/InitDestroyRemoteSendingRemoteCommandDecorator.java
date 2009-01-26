package deus.remoting.command.impl;

import java.util.Map;

import deus.core.User;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.setup.RemoteSendingSetup;

public class InitDestroyRemoteSendingRemoteCommandDecorator extends AbstractRemoteCommandDecorator {

	private Map<TransportIdType, RemoteSendingSetup> remoteSendingInitializerDestroyers;

	private final User user;

	public InitDestroyRemoteSendingRemoteCommandDecorator(User user) {
		this.user = user;
	}


	@Override
	public void beforeExecute(TransportIdType transportIdType) {
		RemoteSendingSetup initializer = remoteSendingInitializerDestroyers.get(transportIdType);
		initializer.setUp(user);
	}


	@Override
	public void afterExecute(TransportIdType transportIdType) {
		RemoteSendingSetup destroyer = remoteSendingInitializerDestroyers.get(transportIdType);
		destroyer.tearDown(user);
	}

}

package deus.remoting.initializerdestroyer.impl;

import java.util.Map;

import deus.core.User;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.initializerdestroyer.RemoteCommand;
import deus.remoting.initializerdestroyer.RemoteSendingInitializerDestroyer;

public class InitDestroyRemoteSendingRemoteCommandDecorator extends AbstractRemoteCommandDecorator {

	private Map<TransportIdType, RemoteSendingInitializerDestroyer> remoteSendingInitializerDestroyers;

	private final User user;

	public InitDestroyRemoteSendingRemoteCommandDecorator(User user) {
		this.user = user;
	}


	@Override
	public void beforeExecute(TransportIdType transportIdType) {
		RemoteSendingInitializerDestroyer initializer = remoteSendingInitializerDestroyers.get(transportIdType);
		initializer.setUp(user);
	}


	@Override
	public void afterExecute(TransportIdType transportIdType) {
		RemoteSendingInitializerDestroyer destroyer = remoteSendingInitializerDestroyers.get(transportIdType);
		destroyer.tearDown(user);
	}

}

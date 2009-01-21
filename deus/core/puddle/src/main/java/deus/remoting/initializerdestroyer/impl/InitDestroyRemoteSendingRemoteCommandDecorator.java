package deus.remoting.initializerdestroyer.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import deus.core.User;
import deus.model.user.id.UserIdType;
import deus.remoting.initializerdestroyer.RemoteCommand;
import deus.remoting.initializerdestroyer.RemoteSendingInitializerDestroyer;

public class InitDestroyRemoteSendingRemoteCommandDecorator extends AbstractRemoteCommandDecorator {


	@Autowired
	@Qualifier("remoteCommand")
	private Map<UserIdType, RemoteSendingInitializerDestroyer> remoteSendingInitializerDestroyers;



	public InitDestroyRemoteSendingRemoteCommandDecorator(RemoteCommand decoratedRemoteCommand) {
		super(decoratedRemoteCommand);
	}

	@Override
	public void beforeExecute(User user) {
		RemoteSendingInitializerDestroyer initializer = remoteSendingInitializerDestroyers.get(user.getUserMetadata()
				.getUserId().getType());
		initializer.setUp(user);
	}


	@Override
	public void afterExecute(User user) {
		RemoteSendingInitializerDestroyer destroyer = remoteSendingInitializerDestroyers.get(user.getUserMetadata()
				.getUserId().getType());
		destroyer.tearDown(user);
	}

}

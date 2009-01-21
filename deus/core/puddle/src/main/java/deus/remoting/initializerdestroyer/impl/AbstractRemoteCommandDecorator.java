package deus.remoting.initializerdestroyer.impl;

import deus.core.User;
import deus.remoting.initializerdestroyer.RemoteCommand;

public abstract class AbstractRemoteCommandDecorator implements RemoteCommand {

	private final RemoteCommand decoratedRemoteCommand;


	public AbstractRemoteCommandDecorator(RemoteCommand decoratedRemoteCommand) {
		this.decoratedRemoteCommand = decoratedRemoteCommand;
	}


	@Override
	public final void execute(User user) {
		beforeExecute(user);

		decoratedRemoteCommand.execute(user);

		afterExecute(user);
	}


	public abstract void beforeExecute(User user);


	public abstract void afterExecute(User user);
	
}

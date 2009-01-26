package deus.remoting.command.impl;

import deus.remoting.command.RemoteCommand;
import deus.remoting.state.RemotingState;

abstract class AbstractRemoteCommandDecorator implements RemoteCommand {

	private final RemoteCommand decoratedRemoteCommand;


	
	public AbstractRemoteCommandDecorator(RemoteCommand decoratedRemoteCommand) {
		this.decoratedRemoteCommand = decoratedRemoteCommand;
	}
	

	@Override
	public final void execute(RemotingState remotingState) {
		beforeExecute(remotingState);

		decoratedRemoteCommand.execute(remotingState);

		afterExecute(remotingState);
	}

	/* (non-Javadoc)
	 * @see deus.remoting.initializerdestroyer.impl.RemoteCommandDecorator#beforeExecute(deus.model.user.transportid.TransportIdType)
	 */
	public abstract void beforeExecute(RemotingState remotingState);


	/* (non-Javadoc)
	 * @see deus.remoting.initializerdestroyer.impl.RemoteCommandDecorator#afterExecute(deus.model.user.transportid.TransportIdType)
	 */
	public abstract void afterExecute(RemotingState remotingState);
		
}

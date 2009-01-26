package deus.remoting.command.impl;

import deus.remoting.command.RemoteCommand;
import deus.remoting.command.RemoteCommandDecorator;
import deus.remoting.state.RemotingState;

abstract class AbstractRemoteCommandDecorator implements RemoteCommandDecorator {

	private RemoteCommand decoratedRemoteCommand;


	@Override
	public final void execute(RemotingState remotingState) {
		beforeExecute(remotingState);

		decoratedRemoteCommand.execute(remotingState);

		afterExecute(remotingState);
	}

	
	public void setDecoratedRemoteCommand(RemoteCommand decoratedRemoteCommand) {
		this.decoratedRemoteCommand = decoratedRemoteCommand;
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

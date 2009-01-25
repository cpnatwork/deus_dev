package deus.remoting.initializerdestroyer.impl;

import deus.model.user.transportid.TransportIdType;
import deus.remoting.initializerdestroyer.RemoteCommand;
import deus.remoting.initializerdestroyer.RemoteCommandDecorator;
import deus.remoting.initializerdestroyer.RemotingStateRegistry;

abstract class AbstractRemoteCommandDecorator implements RemoteCommandDecorator {

	private RemoteCommand decoratedRemoteCommand;


	@Override
	public final void execute(RemotingStateRegistry remotingStateRegistry, TransportIdType transportIdType) {
		beforeExecute(transportIdType);

		decoratedRemoteCommand.execute(remotingStateRegistry, transportIdType);

		afterExecute(transportIdType);
	}

	
	public void setDecoratedRemoteCommand(RemoteCommand decoratedRemoteCommand) {
		this.decoratedRemoteCommand = decoratedRemoteCommand;
	}
	

	/* (non-Javadoc)
	 * @see deus.remoting.initializerdestroyer.impl.RemoteCommandDecorator#beforeExecute(deus.model.user.transportid.TransportIdType)
	 */
	public abstract void beforeExecute(TransportIdType transportIdType);


	/* (non-Javadoc)
	 * @see deus.remoting.initializerdestroyer.impl.RemoteCommandDecorator#afterExecute(deus.model.user.transportid.TransportIdType)
	 */
	public abstract void afterExecute(TransportIdType transportIdType);
	


	
}

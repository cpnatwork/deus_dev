package deus.remoting.command;

import deus.model.user.transportid.TransportIdType;


public interface RemoteCommandDecorator extends RemoteCommand {

	public abstract void beforeExecute(TransportIdType transportIdType);


	public abstract void afterExecute(TransportIdType transportIdType);


	public abstract void setDecoratedRemoteCommand(RemoteCommand remoteCommand);

}
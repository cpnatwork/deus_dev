package deus.remoting.initializerdestroyer.impl;

import deus.model.user.id.transportid.TransportIdType;
import deus.remoting.initializerdestroyer.RemoteCommand;

public abstract class AbstractRemoteCommand implements RemoteCommand {

	protected final TransportIdType transportIdType;
	
	public AbstractRemoteCommand(TransportIdType transportIdType) {
		this.transportIdType = transportIdType;
	}


}

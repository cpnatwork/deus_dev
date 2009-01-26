package deus.remoting.commandexecutor;

import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;

public interface TransportProtocolChoosingStrategy {

	public TransportIdType choseTransportIdType(UserId userId);

	
}

package deus.core.access.transport.core.soul.protocol.callback;

import deus.core.access.transport.core.soul.protocol.TransportId;

public interface RegistrationEventCallback {

	public void registered(TransportId transportId);
	
	public void unregistered(TransportId transportId);
	
}

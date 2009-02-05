package deus.core.transport.core.protocol.callback;

import deus.core.transport.core.protocol.TransportId;

public interface RegistrationEventCallback {

	public void registered(TransportId transportId);
	
	public void unregistered(TransportId transportId);
	
}

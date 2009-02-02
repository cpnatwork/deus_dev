package deus.core.transport.protocol.callback;

import deus.core.transport.protocol.TransportId;

public interface RegistrationEventCallback {

	public void registered(TransportId transportId);
	
	public void unregistered(TransportId transportId);
	
}

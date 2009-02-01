package deus.core.transport.protocolregistry.callback;

import deus.core.transport.id.TransportId;

public interface RegistrationEventCallback {

	public void registered(TransportId transportId);
	
	public void unregistered(TransportId transportId);
	
}

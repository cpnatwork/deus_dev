package deus.core.transport.observers;

import deus.core.transport.id.TransportId;

public interface TransportProtocolPasswordLookup {

	public String getPassword(TransportId transportId);

}

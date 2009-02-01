package deus.core.transport.observers;

import deus.core.transport.id.TransportId;

public interface PasswordLookup {

	public String getPassword(TransportId transportId);

}

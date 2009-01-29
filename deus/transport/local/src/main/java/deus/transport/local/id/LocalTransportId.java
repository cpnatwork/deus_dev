package deus.transport.local.id;

import deus.core.transport.id.TransportId;

public class LocalTransportId implements TransportId {

	private final String username;


	public LocalTransportId(String username) {
		super();
		this.username = username;
	}


	public String getUsername() {
		return username;
	}

}

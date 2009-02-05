package deus.transport.local.core.protocol;

import deus.core.transport.core.protocol.TransportId;

public class LocalTransportId implements TransportId {

	private final String username;


	public LocalTransportId(String username) {
		super();
		this.username = username;
	}


	public String getUsername() {
		return username;
	}


	@Override
	public String getTransportProtocolId() {
		return "local";
	}

}

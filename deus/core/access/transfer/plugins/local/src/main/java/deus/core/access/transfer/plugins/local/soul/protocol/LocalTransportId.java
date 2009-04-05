package deus.core.access.transfer.plugins.local.soul.protocol;

import deus.core.access.transfer.core.soul.protocol.TransferId;

public class LocalTransportId implements TransferId {

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

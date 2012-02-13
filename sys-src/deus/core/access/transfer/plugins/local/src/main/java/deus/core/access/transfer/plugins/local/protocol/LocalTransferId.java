package deus.core.access.transfer.plugins.local.protocol;

import deus.core.access.transfer.common.protocol.TransferId;

public class LocalTransferId implements TransferId {

	private final String username;


	public LocalTransferId(String username) {
		super();
		this.username = username;
	}


	public String getUsername() {
		return username;
	}


	@Override
	public String getTransferProtocolId() {
		return "local";
	}

}

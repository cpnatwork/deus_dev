package deus.core.access.transfer.plugins.testTP.protocol;

import deus.core.access.transfer.common.protocol.TransferId;

public class TestTransferId implements TransferId {

	private final String username;


	public TestTransferId(String username) {
		super();
		this.username = username;
	}


	public String getUsername() {
		return username;
	}


	@Override
	public String toString() {
		return getUsername();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestTransferId other = (TestTransferId) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		}
		else if (!username.equals(other.username))
			return false;
		return true;
	}


	@Override
	public String getTransferProtocolId() {
		return "testProtocol";
	}


}

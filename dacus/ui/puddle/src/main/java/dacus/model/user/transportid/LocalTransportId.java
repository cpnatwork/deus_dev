package dacus.model.user.transportid;

import deus.model.user.transportid.TransportId;
import deus.model.user.transportid.TransportIdType;

public class LocalTransportId implements TransportId {

	private String username; 
	
	@Override
	public TransportIdType getType() {
		return TransportIdType.local;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}

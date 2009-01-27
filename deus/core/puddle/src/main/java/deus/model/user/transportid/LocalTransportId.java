package deus.model.user.transportid;


public class LocalTransportId implements TransportId {

	private String username;


	public LocalTransportId(String username) {
		super();
		this.username = username;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public TransportIdType getType() {
		return TransportIdType.local;
	}
}

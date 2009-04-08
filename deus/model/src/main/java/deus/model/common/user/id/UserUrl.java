package deus.model.common.user.id;


// TODO: think about only injecting username, etc into constructor, no more setters. Also for Transfer ids

// FIXME: REMOVE HIBERNATE STUFF!
//@SuppressWarnings("serial")
//@Entity
public class UserUrl extends UserId {

	private String serverBaseUrl = null;

	public UserUrl(String username, String serverBaseUrl) {
		super();
		setServerBaseUrl(serverBaseUrl);
		setUsername(username);
	}

	@Override
	public UserIdType getType() {
		return UserIdType.url;
	}

	public String getServerBaseUrl() {
		return serverBaseUrl;
	}


	public void setServerBaseUrl(String serverBaseUrl) {
		// FIXME: do check for valid URL, without trailing '/'
		this.serverBaseUrl = serverBaseUrl;
	}


	public String getUrl() {
		return serverBaseUrl + "/" + getUsername();
	}
	
	@Override
	public String getId() {
		return getUrl();
	}
	
	@Override
	public String toString() {
		return getId();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serverBaseUrl == null) ? 0 : serverBaseUrl.hashCode());
		result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
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
		UserUrl other = (UserUrl) obj;
		if (serverBaseUrl == null) {
			if (other.serverBaseUrl != null)
				return false;
		}
		else if (!serverBaseUrl.equals(other.serverBaseUrl))
			return false;
		if (getUsername() == null) {
			if (other.getUsername() != null)
				return false;
		}
		else if (!getUsername().equals(other.getUsername()))
			return false;
		return true;
	}


}

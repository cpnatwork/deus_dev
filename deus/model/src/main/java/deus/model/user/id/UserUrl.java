package deus.model.user.id;

// TODO: think about only injecting username, etc into constructor, no more setters. Also for Transport ids
public class UserUrl extends UserId {

	private String username = null;
	private String serverBaseUrl = null;

	public UserUrl(String username, String serverBaseUrl) {
		super();
		this.serverBaseUrl = serverBaseUrl;
		this.username = username;
	}


	public UserIdType getType() {
		return UserIdType.url;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getServerBaseUrl() {
		return serverBaseUrl;
	}


	public void setServerBaseUrl(String serverBaseUrl) {
		this.serverBaseUrl = serverBaseUrl;
	}


	public String getId() {
		return serverBaseUrl + "/" + username;
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
		UserUrl other = (UserUrl) obj;
		if (serverBaseUrl == null) {
			if (other.serverBaseUrl != null)
				return false;
		}
		else if (!serverBaseUrl.equals(other.serverBaseUrl))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		}
		else if (!username.equals(other.username))
			return false;
		return true;
	}


}

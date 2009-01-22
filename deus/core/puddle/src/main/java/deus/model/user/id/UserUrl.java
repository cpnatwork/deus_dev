package deus.model.user.id;

public class UserUrl extends AbstractUserId {

	private String serverBaseUrl;
	private String username;


	@Override
	public UserIdType getType() {
		return UserIdType.url;
	}


	public String getServerBaseUrl() {
		return serverBaseUrl;
	}


	public void setServerBaseUrl(String serverBaseUrl) {
		this.serverBaseUrl = serverBaseUrl;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	@Override
	public String toString() {
		return serverBaseUrl + username;
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

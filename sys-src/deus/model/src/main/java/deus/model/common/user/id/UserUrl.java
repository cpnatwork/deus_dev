package deus.model.common.user.id;

import java.net.MalformedURLException;
import java.net.URL;


// TODO: think about only injecting username, etc into constructor, no more setters. Also for Transfer ids

// FIXME: REMOVE HIBERNATE STUFF!
//@SuppressWarnings("serial")
//@Entity
public class UserUrl extends UserId {

	private URL serverBaseUrl = null;

	public UserUrl(String username, String serverBaseUrl) {
		super(username);
		try {
			this.serverBaseUrl = new URL(serverBaseUrl);
		}
		catch (MalformedURLException e) {
			throw new RuntimeException("cannot create user URL", e);
		}
	}
	
	public UserUrl(String username, URL serverBaseUrl) {
		super(username);
		this.serverBaseUrl = serverBaseUrl;
	}

	@Override
	public UserIdType getType() {
		return UserIdType.url;
	}

	public URL getServerBaseUrl() {
		return serverBaseUrl;
	}


	public URL getUrl() {
		try {
			return new URL(serverBaseUrl, getUsername());
		}
		catch (MalformedURLException e) {
			throw new RuntimeException("cannot return user URL", e);
		}
	}
	
	
	@Override
	public String getId() {
		return getUrl().toString();
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

package deus.model.user;

import deus.model.user.id.UserId;


public class UserMetadata {

	private UserId userId;
	private String userFullName;


	public UserId getUserId() {
		return userId;
	}


	public void setUserId(UserId userId) {
		this.userId = userId;
	}


	public String getFullName() {
		return userFullName;
	}


	public void setFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	
	@Override
	public String toString() {
		return "id: " + userId + ", full name: " + userFullName;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userFullName == null) ? 0 : userFullName.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		UserMetadata other = (UserMetadata) obj;
		if (userFullName == null) {
			if (other.userFullName != null)
				return false;
		}
		else if (!userFullName.equals(other.userFullName))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		}
		else if (!userId.equals(other.userId))
			return false;
		return true;
	}


}

package deus.model.user;

import deus.model.user.id.UserId;


public class UserMetadata<Id extends UserId> {

	private Id userId;
	private String userFullName;


	public Id getUserId() {
		return userId;
	}


	public void setUserId(Id userId) {
		this.userId = userId;
	}


	public String getFullName() {
		return userFullName;
	}


	public void setFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	
}

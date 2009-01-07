package deus.model.user;

import deus.model.contactprofile.proj.party.PartyId;

public class UserMetadata<T extends PartyId> {

	private T userId;
	private String userFullName;


	public T getUserId() {
		return userId;
	}


	public void setUserId(T userId) {
		this.userId = userId;
	}


	public String getFullName() {
		return userFullName;
	}


	public void setFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	
}

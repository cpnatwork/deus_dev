package deus.model.user;

import deus.model.dossier.proj.party.PartyId;

public class UserMetadata<Id extends PartyId> {

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

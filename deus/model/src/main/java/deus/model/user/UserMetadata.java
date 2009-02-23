package deus.model.user;

import deus.model.dossier.proj.party.Gender;

// TODO: what if userFullName changes??? or gender??? (unknown -> male/female)

public class UserMetadata {

	private String userFullName;

	private Gender gender;


	public UserMetadata() {
		userFullName = "";
		gender = Gender.unknown;
	}


	public UserMetadata(String userFullName, Gender gender) {
		super();
		this.userFullName = userFullName;
		this.gender = gender;
	}


	public String getFullName() {
		return userFullName;
	}


	public void setFullName(String userFullName) {
		this.userFullName = userFullName;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "full name: " + userFullName;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((userFullName == null) ? 0 : userFullName.hashCode());
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
		if (gender == null) {
			if (other.gender != null)
				return false;
		}
		else if (!gender.equals(other.gender))
			return false;
		if (userFullName == null) {
			if (other.userFullName != null)
				return false;
		}
		else if (!userFullName.equals(other.userFullName))
			return false;
		return true;
	}

}

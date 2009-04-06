package deus.model.dc;

import deus.model.user.id.UserId;

public class DigitalCardId {

	private final UserId contributorId;
	private final UserId cpId;

	private final String contributorProvidedDiscriminator;


	public DigitalCardId(UserId contributorId, UserId cpId, String contributorProvidedDiscriminator) {
		super();
		this.contributorId = contributorId;
		this.cpId = cpId;
		this.contributorProvidedDiscriminator = contributorProvidedDiscriminator;
	}


	public UserId getContributorId() {
		return contributorId;
	}


	public UserId getCpId() {
		return cpId;
	}


	public String getContributorProvidedDiscriminator() {
		return contributorProvidedDiscriminator;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contributorId == null) ? 0 : contributorId.hashCode());
		result = prime * result
				+ ((contributorProvidedDiscriminator == null) ? 0 : contributorProvidedDiscriminator.hashCode());
		result = prime * result + ((cpId == null) ? 0 : cpId.hashCode());
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
		DigitalCardId other = (DigitalCardId) obj;
		if (contributorId == null) {
			if (other.contributorId != null)
				return false;
		}
		else if (!contributorId.equals(other.contributorId))
			return false;
		if (contributorProvidedDiscriminator == null) {
			if (other.contributorProvidedDiscriminator != null)
				return false;
		}
		else if (!contributorProvidedDiscriminator.equals(other.contributorProvidedDiscriminator))
			return false;
		if (cpId == null) {
			if (other.cpId != null)
				return false;
		}
		else if (!cpId.equals(other.cpId))
			return false;
		return true;
	}
	
}

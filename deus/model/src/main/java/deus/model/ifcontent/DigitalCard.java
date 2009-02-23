package deus.model.ifcontent;

import deus.model.user.id.UserId;

public abstract class DigitalCard {

	private final UserId contributorId;
	private final UserId cpId;
	private final String nameOfDcInLodEhr;

	private String label;

	// TODO: add dates (creation date? but what about merge operations when adding it to a PIF/FIF)

	public DigitalCard(UserId contributorId, UserId cpId, String nameOfDcInLodEhr) {
		super();
		this.contributorId = contributorId;
		this.cpId = cpId;
		this.nameOfDcInLodEhr = nameOfDcInLodEhr;
	}


	public UserId getContributorId() {
		return contributorId;
	}


	public UserId getCpId() {
		return cpId;
	}


	public String getNameOfDcInLodEhr() {
		return nameOfDcInLodEhr;
	}


	
	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contributorId == null) ? 0 : contributorId.hashCode());
		result = prime * result + ((cpId == null) ? 0 : cpId.hashCode());
		result = prime * result + ((nameOfDcInLodEhr == null) ? 0 : nameOfDcInLodEhr.hashCode());
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
		DigitalCard other = (DigitalCard) obj;
		if (contributorId == null) {
			if (other.contributorId != null)
				return false;
		}
		else if (!contributorId.equals(other.contributorId))
			return false;
		if (cpId == null) {
			if (other.cpId != null)
				return false;
		}
		else if (!cpId.equals(other.cpId))
			return false;
		if (nameOfDcInLodEhr == null) {
			if (other.nameOfDcInLodEhr != null)
				return false;
		}
		else if (!nameOfDcInLodEhr.equals(other.nameOfDcInLodEhr))
			return false;
		return true;
	}

}

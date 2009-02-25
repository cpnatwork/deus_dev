package deus.model.dossier;


public abstract class DigitalCard {

	private final DigitalCardId digitalCardId;

	private String label;


	// TODO: add dates (creation date? but what about merge operations when adding it to a PIF/FIF)


	public DigitalCard(DigitalCardId digitalCardId) {
		super();
		this.digitalCardId = digitalCardId;
	}


	public DigitalCardId getDigitalCardId() {
		return digitalCardId;
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
		result = prime * result + ((digitalCardId == null) ? 0 : digitalCardId.hashCode());
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
		if (digitalCardId == null) {
			if (other.digitalCardId != null)
				return false;
		}
		else if (!digitalCardId.equals(other.digitalCardId))
			return false;
		return true;
	}

}

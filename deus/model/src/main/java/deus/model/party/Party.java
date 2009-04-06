package deus.model.party;

import deus.model.user.id.UserId;

//FIXME: REMOVE HIBERNATE STUFF!
//@Embeddable
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "partytype", discriminatorType = DiscriminatorType.STRING)
public abstract class Party {

	protected UserId id;

	public UserId getId() {
		return id;
	}

	public void setId(UserId id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Party other = (Party) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

package deus.core.access.storage.dossier.model.dc.party;

import java.util.UUID;

public class RelatedPerson extends deus.model.dossier.proj.party.RelatedPerson {

	private UUID id;

	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
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
		RelatedPerson other = (RelatedPerson) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

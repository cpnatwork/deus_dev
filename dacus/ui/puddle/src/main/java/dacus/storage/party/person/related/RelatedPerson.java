package dacus.storage.party.person.related;

import java.net.URL;
import java.util.UUID;

public class RelatedPerson {

	private UUID id;

	// TODO: which type should id take?
	private URL reference;

	private RelatedPersonType type;

	public RelatedPerson() {
		id = UUID.randomUUID();
	}
	
	
	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public URL getReference() {
		return reference;
	}


	public void setReference(URL reference) {
		this.reference = reference;
	}


	public RelatedPersonType getType() {
		return type;
	}


	public void setType(RelatedPersonType type) {
		this.type = type;
	}

}

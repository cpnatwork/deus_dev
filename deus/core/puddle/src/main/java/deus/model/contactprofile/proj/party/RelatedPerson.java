package deus.model.contactprofile.proj.party;

import java.net.URL;

public class RelatedPerson {

	// TODO: which type should id take?
	private URL reference;

	private RelatedPersonType type;


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

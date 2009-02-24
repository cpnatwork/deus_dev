package deus.model.dossier;

import java.util.Set;

public abstract class InformationFile {

	private final Set<DigitalCard> digitalCards;


	public InformationFile(Set<DigitalCard> digitalCards) {
		super();
		this.digitalCards = digitalCards;
	}


	public Set<DigitalCard> getDigitalCards() {
		return digitalCards;
	}

}

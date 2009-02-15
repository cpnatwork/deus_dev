package deus.model.dossier.generic;

import java.util.Set;

import deus.model.dossier.DigitalCard;

public class InformationFile {

	private final Set<DigitalCard> digitalCards;


	public InformationFile(Set<DigitalCard> digitalCards) {
		super();
		this.digitalCards = digitalCards;
	}


	public Set<DigitalCard> getDigitalCards() {
		return digitalCards;
	}

}

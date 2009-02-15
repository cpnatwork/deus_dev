package dacus.model.dossier;

import java.util.Set;

import deus.model.dossier.DigitalCard;
import deus.model.dossier.generic.PersonalInformationFile;

public class PersonalPartyFile extends PersonalInformationFile {

	public PersonalPartyFile(Set<DigitalCard> digitalCards) {
		super(digitalCards);
	}

}

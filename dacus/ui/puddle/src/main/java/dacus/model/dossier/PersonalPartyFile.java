package dacus.model.dossier;

import java.util.Set;

import deus.model.dossier.PersonalInformationFile;
import deus.model.ifcontent.DigitalCard;

public class PersonalPartyFile extends PersonalInformationFile {

	public PersonalPartyFile(Set<DigitalCard> digitalCards) {
		super(digitalCards);
	}

}

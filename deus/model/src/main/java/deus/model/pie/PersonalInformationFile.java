package deus.model.pie;

import java.util.Set;

import deus.model.dossier.DigitalCard;
import deus.model.dossier.InformationFile;
import deus.model.user.id.UserId;


/**
 * All the information, that is stored by people in the two roles LoD-self and LoD-other about the concerned person
 * (CP).
 * 
 * Abbreviation: PIF
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 */
public class PersonalInformationFile extends InformationFile {
	
	public PersonalInformationFile(UserId ownerId, Set<DigitalCard> digitalCards) {
		super(ownerId, digitalCards);
	}
	

}

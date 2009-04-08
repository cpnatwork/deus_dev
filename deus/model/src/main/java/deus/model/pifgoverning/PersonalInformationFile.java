package deus.model.pifgoverning;

import java.util.Set;

import deus.model.common.dossier.DigitalCard;
import deus.model.common.dossier.InformationFile;


/**
 * All the information, that is stored by people in the two roles LoD-self and LoD-other about the concerned person
 * (CP).
 * 
 * Abbreviation: PIF
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 */
public class PersonalInformationFile extends InformationFile {
	
	public PersonalInformationFile(Set<DigitalCard> digitalCards) {
		super(digitalCards);
	}
	
}

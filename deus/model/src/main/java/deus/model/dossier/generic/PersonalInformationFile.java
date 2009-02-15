package deus.model.dossier.generic;

import java.util.Set;

import deus.model.dossier.DigitalCard;


/**
 * All the information, that is stored by people in the two roles LoD-self and LoD-other about the concerned person
 * (CP).
 * 
 * Abbreviation: PIF
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 */
public abstract class PersonalInformationFile extends InformationFile {

	public PersonalInformationFile(Set<DigitalCard> digitalCards) {
		super(digitalCards);
	}

}

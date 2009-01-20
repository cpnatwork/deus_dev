package deus.model.dossier.generic;

import deus.model.user.id.UserId;

/**
 * All the information, that is stored by people in the two roles LoD-self and LoD-other about the concerned person (CP).
 * 
 * Abbreviation: PIF
 *  
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 * @param <Id>	the type of the ID of the concerned person
 * @param <ContentType>	the type of the content, stored in this PIF
 */
public abstract class PersonalInformationFile<Id extends UserId, ContentType> {
	
	private ContentType content;
	
}

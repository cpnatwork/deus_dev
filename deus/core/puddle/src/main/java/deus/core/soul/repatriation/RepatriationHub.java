package deus.core.soul.repatriation;

import deus.model.pie.PersonalInformationFile;
import deus.model.user.id.UserId;


// FIXME: edit javadoc
/**
 * This system interface is responsible for receiving contributed digital cards (either from the user itself or from
 * another user) to be committed into the PIF.
 * 
 * The passed ID of the contributor must match the ID of the contributor in the digital card!
 * 
 * The ID of the user, to which this contribution counter belongs must match the ID of the CP in the digital card!
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface RepatriationHub extends RepatriationHubExportedToClient, RepatriationHubExportedToPeer {

	// FIXME: replace this by list of DigitalCard IDs
	public PersonalInformationFile getPersonalInformationFile(UserId cpId);
	
}

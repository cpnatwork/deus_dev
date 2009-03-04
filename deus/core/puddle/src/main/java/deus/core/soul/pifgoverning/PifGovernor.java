package deus.core.soul.pifgoverning;

import deus.model.dossier.DigitalCard;
import deus.model.pie.PersonalInformationFile;
import deus.model.user.id.UserId;

public interface PifGovernor {

	/**
	 * Plain edit of PIF without any restrictions.
	 * 
	 * @param userId
	 * @param personalInformationFile
	 */
	//public void updatePersonalInformationFile(UserId cpId, PersonalInformationFile personalInformationFile);

	
	public void assimilateRepatriatedDigitalCard(UserId cpId, DigitalCard digitalCard);
	


	// FIXME: replace this by list of DigitalCard IDs
	public PersonalInformationFile getPersonalInformationFile(UserId cpId);
	
}

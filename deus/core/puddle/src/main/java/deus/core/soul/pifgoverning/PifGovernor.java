package deus.core.soul.pifgoverning;

import deus.model.dossier.DigitalCard;
import deus.model.user.id.UserId;

public interface PifGovernor extends PifGovernorExportedToClient {

	/**
	 * Plain edit of PIF without any restrictions.
	 * 
	 * @param userId
	 * @param personalInformationFile
	 */
	//public void updatePersonalInformationFile(UserId cpId, PersonalInformationFile personalInformationFile);


	// FIXME: think about whether this goes to its own interface PifGovernorExportedToSubsystems
	// FIXME: return a Patch
	public void assimilateRepatriatedDigitalCard(UserId cpId, DigitalCard digitalCard);
	
}

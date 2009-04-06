package deus.core.soul.pifgoverning;

import deus.model.dc.DigitalCard;
import deus.model.dossier.Patch;
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
	public Patch assimilateRepatriatedDigitalCard(UserId cpId, DigitalCard digitalCard);
	
}

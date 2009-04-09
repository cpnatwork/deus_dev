package deus.core.soul.pifgoverning;

import deus.model.common.dossier.DigitalCard;
import deus.model.common.dossier.Patch;
import deus.model.common.user.frids.RepatriationAuthorityId;

public interface PifGovernor extends PifGovernorExportedToClient {

	/**
	 * Plain edit of PIF without any restrictions.
	 * 
	 * @param userId
	 * @param personalInformationFile
	 */
	//public void updatePersonalInformationFile(UserId cpId, PersonalInformationFile personalInformationFile);


	// FIXME: think about whether this goes to its own interface PifGovernorExportedToSubsystems
	public Patch assimilateRepatriatedDigitalCard(RepatriationAuthorityId repatriationAuthorityId, DigitalCard digitalCard);
	
}

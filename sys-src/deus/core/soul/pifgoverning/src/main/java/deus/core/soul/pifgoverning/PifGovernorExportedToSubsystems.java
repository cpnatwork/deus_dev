package deus.core.soul.pifgoverning;

import deus.model.common.dossier.DigitalCard;
import deus.model.common.dossier.Patch;
import deus.model.common.user.frids.RepatriationAuthorityId;

public interface PifGovernorExportedToSubsystems {

	/**
	 * Plain edit of PIF without any restrictions.
	 * 
	 * @param userId
	 * @param personalInformationFile
	 */
	// public void updatePersonalInformationFile(UserId cpId,
	// PersonalInformationFile personalInformationFile);

	public Patch assimilateRepatriatedDigitalCard(RepatriationAuthorityId repatriationAuthorityId,
			DigitalCard digitalCard);

}
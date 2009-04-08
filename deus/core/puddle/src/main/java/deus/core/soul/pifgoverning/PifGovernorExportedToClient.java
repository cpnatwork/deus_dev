package deus.core.soul.pifgoverning;

import deus.model.common.user.id.UserId;
import deus.model.pifgoverning.PersonalInformationFile;


public interface PifGovernorExportedToClient {

	// FIXME: replace this by list of DigitalCard IDs
	public abstract PersonalInformationFile getPersonalInformationFile(UserId cpId);

}
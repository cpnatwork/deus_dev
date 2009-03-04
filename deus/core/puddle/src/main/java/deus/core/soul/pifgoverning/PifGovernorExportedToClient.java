package deus.core.soul.pifgoverning;

import deus.model.pie.PersonalInformationFile;
import deus.model.user.id.UserId;


public interface PifGovernorExportedToClient {

	// FIXME: replace this by list of DigitalCard IDs
	public abstract PersonalInformationFile getPersonalInformationFile(UserId cpId);

}
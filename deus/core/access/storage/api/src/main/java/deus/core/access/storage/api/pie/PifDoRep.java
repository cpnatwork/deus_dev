package deus.core.access.storage.api.pie;

import deus.model.pifgoverning.PersonalInformationFile;
import deus.model.user.id.UserId;

public interface PifDoRep {
	
	public void updateEntity(UserId cpId, PersonalInformationFile personalInformationFile);

	public PersonalInformationFile getByNaturalId(UserId cpId);

}

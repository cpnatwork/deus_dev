package deus.core.access.storage.api.pie;

import deus.model.common.user.id.UserId;
import deus.model.pifgoverning.PersonalInformationFile;

public interface PifDoRep {
	
	public void updateEntity(UserId cpId, PersonalInformationFile personalInformationFile);

	public PersonalInformationFile getByNaturalId(UserId cpId);

}

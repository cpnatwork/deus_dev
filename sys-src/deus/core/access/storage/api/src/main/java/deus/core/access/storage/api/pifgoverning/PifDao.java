package deus.core.access.storage.api.pifgoverning;

import deus.model.common.user.frids.RepatriationAuthorityId;
import deus.model.pifgoverning.PersonalInformationFile;

public interface PifDao {

	PersonalInformationFile getByNaturalId(RepatriationAuthorityId repatriationAuthorityId);

	void updateEntity(RepatriationAuthorityId repatriationAuthorityId, PersonalInformationFile personalInformationFile);

}

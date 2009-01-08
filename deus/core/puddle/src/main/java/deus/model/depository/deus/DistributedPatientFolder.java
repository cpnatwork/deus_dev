package deus.model.depository.deus;

import deus.model.depository.DistributedInformationFolder;
import deus.model.dossier.deus.ForeignPatientFile;
import deus.model.user.id.UserId;

public interface DistributedPatientFolder<Id extends UserId> extends
		DistributedInformationFolder<Id, ForeignPatientFile<Id>> {

}

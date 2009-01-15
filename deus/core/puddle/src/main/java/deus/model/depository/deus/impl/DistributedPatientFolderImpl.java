package deus.model.depository.deus.impl;

import deus.model.depository.deus.DistributedPatientFolder;
import deus.model.depository.generic.impl.DistributedInformationFolderImpl;
import deus.model.dossier.deus.ForeignPatientFile;
import deus.model.user.id.UserId;

public class DistributedPatientFolderImpl<Id extends UserId> extends
		DistributedInformationFolderImpl<Id, ForeignPatientFile<Id>> implements DistributedPatientFolder<Id> {

}

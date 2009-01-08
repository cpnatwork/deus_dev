package deus.model.sub.deus;

import deus.model.dossier.deus.ForeignPatientFile;
import deus.model.sub.DistributedInformationFolder;
import deus.model.user.id.UserId;

public class DistributedPatientFolder<Id extends UserId> extends DistributedInformationFolder<Id, ForeignPatientFile<Id>> {

}

package deus.model.sub.deus;

import deus.model.dossier.deus.ForeignPatientFile;
import deus.model.dossier.proj.party.PartyId;
import deus.model.sub.DistributedInformationFolder;

public class DistributedPatientFolder<Id extends PartyId> extends DistributedInformationFolder<Id, ForeignPatientFile<Id>> {

}

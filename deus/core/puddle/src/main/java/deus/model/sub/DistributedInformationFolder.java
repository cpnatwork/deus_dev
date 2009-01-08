package deus.model.sub;

import java.util.List;

import deus.model.dossier.ForeignInformationFile;
import deus.model.dossier.proj.party.PartyId;

public abstract class DistributedInformationFolder<Id extends PartyId, ContentType> {

	protected List<ForeignInformationFile<Id, ContentType>> foreignInformationFiles;
	
}

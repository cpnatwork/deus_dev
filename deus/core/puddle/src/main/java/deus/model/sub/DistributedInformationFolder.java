package deus.model.sub;

import java.util.List;

import deus.model.dossier.ForeignInformationFile;
import deus.model.user.id.UserId;

public abstract class DistributedInformationFolder<Id extends UserId, ContentType> {

	protected List<ForeignInformationFile<Id, ContentType>> foreignInformationFiles;
	
}

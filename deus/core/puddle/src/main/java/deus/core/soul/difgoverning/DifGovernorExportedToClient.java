package deus.core.soul.difgoverning;

import deus.model.dossier.DigitalCard;
import deus.model.dossier.DigitalCardId;
import deus.model.sub.DistributedInformationFolder;
import deus.model.sub.ForeignInformationFile;
import deus.model.user.id.UserId;

public interface DifGovernorExportedToClient {

	// FIXME: replace this by list of FIF IDs
	public abstract DistributedInformationFolder getDistributedInformationFolder(UserId residentId);


	// FIXME: replace this by list of DC IDs
	public abstract ForeignInformationFile getForeignInformationFile(UserId residentId, UserId cpId);


	public abstract DigitalCard getDigitalCard(UserId residentId, DigitalCardId digitalCardId);

}

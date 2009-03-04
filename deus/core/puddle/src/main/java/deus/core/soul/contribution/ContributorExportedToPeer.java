package deus.core.soul.contribution;

import deus.model.dossier.DigitalCardId;
import deus.model.user.id.UserId;


// FIXME: move to transport module
public interface ContributorExportedToPeer {

	public void acknowledgeContribution(UserId contributorId, DigitalCardId digitalCardId);
	
	public void denyContribution(UserId contributorId, DigitalCardId digitalCardId);
	
}

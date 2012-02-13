package deus.core.access.transfer.core.receiving.soulcallback.contribution;

import deus.model.common.dossier.DigitalCardId;
import deus.model.common.user.frids.ContributorId;


public interface ContributorExportedToPeers {

	public void contributionAcknowledged(ContributorId contributorId, DigitalCardId digitalCardId);
	
	public void contributionDenied(ContributorId contributorId, DigitalCardId digitalCardId);
	
}

package deus.core.access.transfer.core.receiving.soulcallback.contribution;

import deus.model.dc.DigitalCardId;
import deus.model.user.id.UserId;


public interface ContributorExportedToPeers {

	public void contributionAcknowledged(UserId contributorId, DigitalCardId digitalCardId);
	
	public void contributionDenied(UserId contributorId, DigitalCardId digitalCardId);
	
}

package deus.core.soul.contribution;

import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.frids.ContributorId;
import deus.model.common.user.frids.RepatriationAuthorityId;

public interface ContributorExportedToClient {

	public void forwardToCp(ContributorId contributorId, RepatriationAuthorityId repatriationAuthorityId, DigitalCard digitalCard);
	
}

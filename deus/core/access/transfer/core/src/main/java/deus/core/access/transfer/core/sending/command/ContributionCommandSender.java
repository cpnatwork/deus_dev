package deus.core.access.transfer.core.sending.command;

import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.frids.ContributorId;
import deus.model.common.user.frids.RepatriationAuthorityId;

public interface ContributionCommandSender {
	
	public void forwardToCp(ContributorId contributorId, RepatriationAuthorityId repatriationAuthorityId,
			DigitalCard digitalCard);

}

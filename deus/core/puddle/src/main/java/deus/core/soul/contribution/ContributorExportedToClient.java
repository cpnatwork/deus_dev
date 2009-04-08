package deus.core.soul.contribution;

import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.id.UserId;

public interface ContributorExportedToClient {

	public void forwardToCp(UserId contributorId, UserId cpId, DigitalCard digitalCard);
	
}

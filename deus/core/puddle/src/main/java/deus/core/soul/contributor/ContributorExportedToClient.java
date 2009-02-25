package deus.core.soul.contributor;

import deus.model.dossier.DigitalCard;
import deus.model.user.id.UserId;

public interface ContributorExportedToClient {

	public void forwardToCp(UserId contributorId, UserId cpId, DigitalCard digitalCard);
	
}

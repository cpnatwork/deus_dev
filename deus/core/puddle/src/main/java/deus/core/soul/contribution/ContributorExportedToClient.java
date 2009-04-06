package deus.core.soul.contribution;

import deus.model.dc.DigitalCard;
import deus.model.user.id.UserId;

public interface ContributorExportedToClient {

	public void forwardToCp(UserId contributorId, UserId cpId, DigitalCard digitalCard);
	
}

package deus.core.soul.difgoverning;

import java.util.List;

import deus.model.dc.DigitalCard;
import deus.model.dc.DigitalCardId;
import deus.model.user.id.UserId;

public interface DifGovernorExportedToClient {
	
	public List<UserId> getPublishersInDif(UserId subscriberId);
	

	public List<DigitalCardId> getDigitalCardIdsInFif(UserId subscriberId, UserId publisherId);

	
	public DigitalCard getDigitalCardInFif(UserId subscriberId, DigitalCardId digitalCardId);

}

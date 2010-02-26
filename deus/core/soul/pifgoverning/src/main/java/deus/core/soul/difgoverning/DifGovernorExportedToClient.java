package deus.core.soul.difgoverning;

import java.util.List;

import deus.model.common.dossier.DigitalCard;
import deus.model.common.dossier.DigitalCardId;
import deus.model.common.user.id.UserId;

public interface DifGovernorExportedToClient {
	
	public List<UserId> getPublishersInDif(UserId subscriberId);
	

	public List<DigitalCardId> getDigitalCardIdsInFif(UserId subscriberId, UserId publisherId);

	
	public DigitalCard getDigitalCardInFif(UserId subscriberId, DigitalCardId digitalCardId);

}

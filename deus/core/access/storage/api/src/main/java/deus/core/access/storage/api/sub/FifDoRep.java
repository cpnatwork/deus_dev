package deus.core.access.storage.api.sub;

import java.util.List;

import deus.model.dc.DigitalCard;
import deus.model.dc.DigitalCardId;
import deus.model.difgoverning.ForeignInformationFile;
import deus.model.user.id.UserId;


public interface FifDoRep {

	public ForeignInformationFile getByNaturalId(UserId publisherId, UserId subscriberId);


	public List<DigitalCardId> getDigitalCardsInFif(UserId subscriberId, UserId publisherId);


	public DigitalCard getDigitalCardInFif(UserId subscriberId, DigitalCardId digitalCardId);


	public void updateEntity(UserId residentId, UserId cpId, ForeignInformationFile foreignInformationFile);

}

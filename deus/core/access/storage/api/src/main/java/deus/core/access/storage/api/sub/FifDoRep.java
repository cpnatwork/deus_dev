package deus.core.access.storage.api.sub;

import java.util.List;

import deus.model.common.dossier.DigitalCard;
import deus.model.common.dossier.DigitalCardId;
import deus.model.common.user.id.UserId;
import deus.model.difgoverning.ForeignInformationFile;


public interface FifDoRep {

	public ForeignInformationFile getByNaturalId(UserId publisherId, UserId subscriberId);


	public List<DigitalCardId> getDigitalCardsInFif(UserId subscriberId, UserId publisherId);


	public DigitalCard getDigitalCardInFif(UserId subscriberId, DigitalCardId digitalCardId);


	public void updateEntity(UserId residentId, UserId cpId, ForeignInformationFile foreignInformationFile);

}

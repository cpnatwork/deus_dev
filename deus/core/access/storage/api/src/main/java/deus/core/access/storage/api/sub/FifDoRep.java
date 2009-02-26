package deus.core.access.storage.api.sub;

import java.util.List;

import deus.model.dossier.DigitalCard;
import deus.model.dossier.DigitalCardId;
import deus.model.sub.ForeignInformationFile;
import deus.model.user.id.UserId;


public interface FifDoRep {

	public ForeignInformationFile getByNaturalId(UserId publisherId, UserId subscriberId);

	public List<DigitalCardId> getDigitalCardsInFif(UserId subscriberId, UserId publisherId);

	public DigitalCard getDigitalCardInFif(UserId subscriberId, DigitalCardId digitalCardId);

}

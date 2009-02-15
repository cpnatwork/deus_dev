package dacus.model.dossier;

import java.util.Set;

import deus.model.dossier.DigitalCard;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public class ForeignPartyFile extends ForeignInformationFile {

	public ForeignPartyFile(UserId publisherId, UserMetadata publisherMetadata, Set<DigitalCard> digitalCards) {
		super(publisherId, publisherMetadata, digitalCards);
	}

}

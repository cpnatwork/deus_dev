package deus.core.access.storage.api.sub;

import deus.model.sub.ForeignInformationFile;
import deus.model.user.id.UserId;


public interface FifDoRep {

	public ForeignInformationFile getByNaturalId(UserId publisherId, UserId subscriberId);

}

package deus.core.access.storage.api.sub.api;

import deus.model.sub.DistributedInformationFolder;
import deus.model.user.id.UserId;


public interface DifDoRep {

	public DistributedInformationFolder getByNaturalId(UserId subscriberId);

}

package deus.core.access.storage.api.sub;

import java.util.List;

import deus.model.sub.DistributedInformationFolder;
import deus.model.user.id.UserId;


public interface DifDoRep {

	@Deprecated
	public DistributedInformationFolder getByNaturalId(UserId subscriberId);

	public List<UserId> getPublishersInDif(UserId subscriberId);

}

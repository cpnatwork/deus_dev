package deus.core.access.storage.api.sub;

import java.util.List;

import deus.model.common.user.id.UserId;
import deus.model.difgoverning.DistributedInformationFolder;


public interface DifDoRep {

	@Deprecated
	public DistributedInformationFolder getByNaturalId(UserId subscriberId);

	public List<UserId> getPublishersInDif(UserId subscriberId);

}

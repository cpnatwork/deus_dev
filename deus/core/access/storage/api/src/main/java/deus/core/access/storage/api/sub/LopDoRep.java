package deus.core.access.storage.api.sub;

import deus.model.common.user.id.UserId;
import deus.model.subscription.ListOfPublishers;


public interface LopDoRep {

	public ListOfPublishers getByNaturalId(UserId subscriberId);

}

package deus.core.access.storage.api.sub;

import deus.model.sub.ListOfPublishers;
import deus.model.user.id.UserId;


public interface LopDoRep {

	public ListOfPublishers getByNaturalId(UserId subscriberId);

}

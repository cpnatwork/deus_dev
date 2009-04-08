package deus.core.access.storage.api.pub;

import deus.model.common.user.id.UserId;
import deus.model.publication.ListOfSubscribers;

public interface LosDoRep {

	public ListOfSubscribers getByNaturalId(UserId publisherId);

	public ListOfSubscribers deleteAllEntities(UserId publisherId);

}

package deus.core.access.storage.api.pub;

import deus.model.publication.ListOfSubscribers;
import deus.model.user.id.UserId;

public interface LosDoRep {

	public ListOfSubscribers getByNaturalId(UserId publisherId);

	public ListOfSubscribers deleteAllEntities(UserId publisherId);

}

package deus.core.access.storage.api.pub;

import deus.model.common.user.frids.PublisherId;
import deus.model.publication.ListOfSubscribers;

public interface LosDoRep {

	public ListOfSubscribers getByNaturalId(PublisherId publisherId);

	public ListOfSubscribers deleteAllEntities(PublisherId publisherId);

}

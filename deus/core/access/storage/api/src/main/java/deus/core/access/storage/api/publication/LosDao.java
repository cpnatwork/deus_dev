package deus.core.access.storage.api.publication;

import deus.model.common.user.frids.PublisherId;
import deus.model.publication.ListOfSubscribers;

public interface LosDao {

	ListOfSubscribers getByNaturalId(PublisherId publisherId);

}

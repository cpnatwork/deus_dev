package deus.core.access.storage.api.subscription;

import deus.model.common.user.frids.SubscriberId;
import deus.model.subscription.ListOfPublishers;

public interface LopDao {

	ListOfPublishers getByNaturalId(SubscriberId subscriberId);

}

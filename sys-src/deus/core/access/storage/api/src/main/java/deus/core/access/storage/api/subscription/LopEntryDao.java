package deus.core.access.storage.api.subscription;

import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.subscription.LopEntry;

public interface LopEntryDao {

	LopEntry getByNaturalId(SubscriberId subscriberId, PublisherId publisherId);


	void updateEntity(SubscriberId subscriberId, LopEntry entry);


	void deleteByNaturalId(SubscriberId subscriberId, PublisherId publisherId);


	boolean existsByNaturalId(SubscriberId subscriberId, PublisherId publisherId);


	void addNewEntity(SubscriberId subscriberId, LopEntry entry);

}

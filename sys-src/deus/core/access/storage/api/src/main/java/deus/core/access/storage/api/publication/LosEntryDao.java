package deus.core.access.storage.api.publication;

import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.publication.LosEntry;

public interface LosEntryDao {

	public LosEntry getByNaturalId(PublisherId publisherId, SubscriberId subscriberId);


	public void deleteByNaturalId(PublisherId publisherId, SubscriberId subscriberId);


	public void updateEntity(PublisherId publisherId, LosEntry entry);


	public void addNewEntity(PublisherId publisherId, LosEntry entry);


	public boolean existsByNaturalId(PublisherId publisherId, SubscriberId subscriberId);

}

package deus.core.access.storage.api.publication;

import deus.model.common.user.id.UserId;
import deus.model.publication.LosEntry;

public interface LosEntryDao {

	public LosEntry getByNaturalId(UserId subscriberId, UserId publisherId);


	public void deleteByNaturalId(UserId subscriberId, UserId publisherId);


	public void updateEntity(UserId publisherId, LosEntry entry);


	public void addNewEntity(UserId publisherId, LosEntry entry);


	public boolean existsByNaturalId(UserId subscriberId, UserId publisherId);

}

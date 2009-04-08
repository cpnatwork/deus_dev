package deus.core.access.storage.api.pub;

import deus.model.common.user.id.UserId;
import deus.model.publication.LosEntry;

public interface LosEntryDoRep {

	public void addNewEntity(UserId publisherId, LosEntry entry);


	public void deleteByNaturalId(UserId subscriberId, UserId publisherId);


	public void updateEntity(UserId publisherId, LosEntry entry);


	public LosEntry getByNaturalId(UserId subscriberId, UserId publisherId);


	public boolean containsEntity(UserId subscriberId, UserId publisherId);
	
}

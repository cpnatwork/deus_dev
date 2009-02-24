package deus.core.access.storage.api.pub.api;

import deus.model.pub.LosEntry;
import deus.model.user.id.UserId;

public interface LosEntryDoRep {

	public void addNewEntity(UserId publisherId, LosEntry entry);


	public void deleteByNaturalId(UserId subscriberId, UserId publisherId);


	public void updateEntity(UserId subscriberId, LosEntry entry);


	public LosEntry getByNaturalId(UserId subscriberId, UserId publisherId);


	public boolean containsEntity(UserId subscriberId, UserId publisherId);
	
}

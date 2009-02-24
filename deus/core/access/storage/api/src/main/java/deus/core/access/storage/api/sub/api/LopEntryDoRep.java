package deus.core.access.storage.api.sub.api;

import deus.model.sub.LopEntry;
import deus.model.user.id.UserId;

public interface LopEntryDoRep {

	public boolean containsEntity(UserId publisherId, UserId subscriberId);

	public LopEntry getByNaturalId(UserId publisherId, UserId subscriberId);

	public void updateEntity(LopEntry entry);

	public void deleteByNaturalId(UserId publisherId, UserId subscriberId);

	public void addNewEntity(UserId subscriberId, LopEntry entry);
	
}

package deus.core.access.storage.api.sub;

import deus.model.subscription.LopEntry;
import deus.model.user.id.UserId;

public interface LopEntryDoRep {

	public void addNewEntity(UserId subscriberId, LopEntry entry);


	public void deleteByNaturalId(UserId publisherId, UserId subscriberId);


	public void updateEntity(UserId subscriberId, LopEntry entry);


	public LopEntry getByNaturalId(UserId publisherId, UserId subscriberId);


	public boolean containsEntity(UserId publisherId, UserId subscriberId);

}

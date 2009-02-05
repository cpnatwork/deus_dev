package deus.core.access.storage.sub;

import deus.core.access.storage.Dao;
import deus.model.sub.ListOfPublishers;
import deus.model.user.id.UserId;

public interface SubDao extends Dao<ListOfPublishers, UserId> {

	public ListOfPublishers getListOfPublishers(UserId lopOwnerUserId);
	
}

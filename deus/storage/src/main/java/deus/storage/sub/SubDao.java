package deus.storage.sub;

import deus.model.sub.ListOfPublishers;
import deus.model.user.id.UserId;
import deus.storage.Dao;

public interface SubDao extends Dao<ListOfPublishers, UserId> {

	public ListOfPublishers getListOfPublishers(UserId lopOwnerUserId);
	
}

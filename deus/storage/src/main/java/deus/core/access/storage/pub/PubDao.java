package deus.core.access.storage.pub;

import deus.core.access.storage.Dao;
import deus.model.pub.ListOfSubscribers;
import deus.model.user.id.UserId;

public interface PubDao extends Dao<ListOfSubscribers, UserId>{

	public ListOfSubscribers getListOfSubscribers(UserId losOwnerUserId);

}

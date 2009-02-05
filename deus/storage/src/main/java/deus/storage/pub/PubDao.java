package deus.storage.pub;

import deus.model.pub.ListOfSubscribers;
import deus.model.user.id.UserId;
import deus.storage.Dao;

public interface PubDao extends Dao<ListOfSubscribers, UserId>{

	public ListOfSubscribers getListOfSubscribers(UserId losOwnerUserId);

}

package deus.core.access.storage.api.pub.api;

import deus.core.access.storage.api.common.Dao;
import deus.model.pub.ListOfSubscribers;
import deus.model.user.id.UserId;

public interface PubDao extends Dao<ListOfSubscribers, UserId>{

	public ListOfSubscribers getListOfSubscribers(UserId losOwnerUserId);

}

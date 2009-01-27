package deus.storage.pub;

import deus.model.pub.ListOfSubscribers;
import deus.model.user.id.UserId;

public interface PubDao {

	public ListOfSubscribers getListOfSubscribers(UserId userId);

}

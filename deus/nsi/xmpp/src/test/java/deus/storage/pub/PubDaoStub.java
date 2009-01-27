package deus.storage.pub;

import deus.model.pub.ListOfSubscribers;
import deus.model.pub.impl.ThreadSafeListOfSubscribers;
import deus.model.user.id.UserId;

public class PubDaoStub implements PubDao {


	@Override
	public ListOfSubscribers getListOfSubscribers(UserId userId) {
		return new ThreadSafeListOfSubscribers();
	}

}

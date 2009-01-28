package deus.storage.pub.impl;

import org.springframework.stereotype.Component;

import deus.model.pub.ListOfSubscribers;
import deus.model.pub.impl.ThreadSafeListOfSubscribers;
import deus.model.user.id.UserId;
import deus.storage.pub.PubDao;

@Component
public class PubDaoStub implements PubDao {


	@Override
	public ListOfSubscribers getListOfSubscribers(UserId userId) {
		return new ThreadSafeListOfSubscribers();
	}

}

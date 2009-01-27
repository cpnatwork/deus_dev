package deus.storage.pub;

import deus.model.pub.ListOfSubscribers;
import deus.model.pub.impl.ThreadSafeListOfSubscribers;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;

public class PubDaoStub implements PubDao {


	@Override
	public ListOfSubscribers getListOfSubscribers(UserId userId) {
		return new ThreadSafeListOfSubscribers();
	}


	@Override
	public PublisherMetadata getPublisherMetadata(UserId userId) {
		// TODO Auto-generated method stub
		return null;
	}

}

package deus.storage.sub;

import deus.model.pub.SubscriberMetadata;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.impl.ThreadSafeListOfPublishers;
import deus.model.user.id.UserId;

public class SubDaoStub implements SubDao {

	@Override
	public SubscriberMetadata getSubscriberMetadata(UserId userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListOfPublishers getListOfPublishers(UserId userId) {
		return new ThreadSafeListOfPublishers();
	}

}

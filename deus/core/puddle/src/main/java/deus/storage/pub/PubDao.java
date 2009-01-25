package deus.storage.pub;

import deus.model.pub.ListOfSubscribers;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;

public interface PubDao {


	public PublisherMetadata getPublisherMetadata(UserId userId);


	public ListOfSubscribers getListOfSubscribers(UserId userId);


	public ListOfPublishers getListOfPublishers(UserId userId);

}

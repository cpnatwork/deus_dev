package deus.core;

import deus.core.barker.Barker;
import deus.core.lodother.LodOther;
import deus.core.lodself.LodSelf;
import deus.core.publisher.Publisher;
import deus.core.subscriber.Subscriber;
import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.pub.ListOfSubscribers;
import deus.model.sub.ListOfPublishers;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public class User<Id extends UserId, PifContentType, DifType extends DistributedInformationFolder<Id, ?>, FifContentType> {

	UserMetadata<Id> userMetadata;
	
	Publisher<Id> publisher;
	Subscriber<Id, DifType, FifContentType> subscriber;
	
	LodSelf<Id, PifContentType> lodSelf;
	LodOther lodOther;
	
	Barker barker;

	public UserMetadata<Id> getUserMetadata() {
		return userMetadata;
	}

	public String toString() {
		return userMetadata.getUserId().toString();
	}
	
	public ListOfSubscribers getListOfSubscribers() {
		return publisher.getListOfSubscribers();
	}
	
	public ListOfPublishers getListOfPublishers() {
		// FIXME: implement!
		// return subscriber.getListOfPublishers();
		return null;
	}
}

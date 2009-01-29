package deus.core.soul;

import deus.core.soul.barker.Barker;
import deus.core.soul.lodother.LodOther;
import deus.core.soul.lodself.LodSelf;
import deus.core.soul.publisher.Publisher;
import deus.core.soul.subscriber.Subscriber;
import deus.model.pub.ListOfSubscribers;
import deus.model.sub.ListOfPublishers;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public class User {

	UserMetadata userMetadata;

	Publisher publisher;
	Subscriber subscriber;

	LodSelf lodSelf;
	LodOther lodOther;

	Barker barker;

	public Barker getBarker() {
		return barker;
	}


	public UserMetadata getUserMetadata() {
		return userMetadata;
	}


	public UserId getUserId() {
		return userMetadata.getUserId();
	}


	public String toString() {
		return userMetadata.getUserId().toString();
	}


	public ListOfSubscribers getListOfSubscribers() {
		return publisher.getListOfSubscribers();
	}


	public ListOfPublishers getListOfPublishers() {
		return subscriber.getListOfPublishers();
	}


	public void setUserMetadata(UserMetadata userMetadata) {
		this.userMetadata = userMetadata;
	}


	public Publisher getPublisher() {
		return publisher;
	}


	public Subscriber getSubscriber() {
		return subscriber;
	}

}

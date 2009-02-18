package deus.core.soul;

import deus.core.soul.barker.BarkerExportedToClient;
import deus.core.soul.contribution.hub.ContributionHubExportedToPeer;
import deus.core.soul.publisher.Publisher;
import deus.core.soul.subscriber.Subscriber;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public class User {

	UserId userId;
	UserMetadata userMetadata;

	Publisher publisher;
	Subscriber subscriber;

	ContributionHubExportedToPeer contributionHub;

	BarkerExportedToClient barker;

	public BarkerExportedToClient getBarker() {
		return barker;
	}


	public UserMetadata getUserMetadata() {
		return userMetadata;
	}


	public UserId getUserId() {
		return userId;
	}


	public String toString() {
		return userId.toString();
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

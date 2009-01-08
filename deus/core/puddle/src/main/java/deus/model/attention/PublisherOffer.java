package deus.model.attention;

import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;

public class PublisherOffer<Id extends UserId> extends DecisionToMake {

	private final PublisherMetadata<Id> publisher;
	private boolean confirmed;


	public PublisherOffer(PublisherMetadata<Id> publisher) {
		this.publisher = publisher;
	}


	public PublisherMetadata<Id> getPublisher() {
		return publisher;
	}


	public boolean isConfirmed() {
		return confirmed;
	}


	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

}

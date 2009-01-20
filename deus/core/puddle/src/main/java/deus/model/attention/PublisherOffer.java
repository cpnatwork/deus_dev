package deus.model.attention;

import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;

public class PublisherOffer<Id extends UserId> extends ConnectionDecisionToMake {

	private final PublisherMetadata<Id> publisher;


	public PublisherOffer(PublisherMetadata<Id> publisher) {
		this.publisher = publisher;
	}


	public PublisherMetadata<Id> getPublisher() {
		return publisher;
	}

}

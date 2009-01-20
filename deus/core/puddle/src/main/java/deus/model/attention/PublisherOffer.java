package deus.model.attention;

import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;

public class PublisherOffer<Id extends UserId> extends ConnectionDecisionToMake {

	private final PublisherMetadata<Id> publisherMetadata;


	public PublisherOffer(PublisherMetadata<Id> publisherMetadata) {
		this.publisherMetadata = publisherMetadata;
	}


	public PublisherMetadata<Id> getPublisher() {
		return publisherMetadata;
	}

}

package deus.model.attention;

import deus.model.sub.PublisherMetadata;

public class PublisherOffer extends ConnectionDecisionToMake {

	private final PublisherMetadata publisherMetadata;


	public PublisherOffer(PublisherMetadata publisherMetadata) {
		this.publisherMetadata = publisherMetadata;
	}


	public PublisherMetadata getPublisher() {
		return publisherMetadata;
	}


	@Override
	public DecisionType getType() {
		return DecisionType.publisherOffer;
	}

}

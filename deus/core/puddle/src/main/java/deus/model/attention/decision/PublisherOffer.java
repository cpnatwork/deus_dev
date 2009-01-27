package deus.model.attention.decision;

import deus.model.user.UserMetadata;

public class PublisherOffer extends ConnectionDecisionToMake {

	private final UserMetadata publisherMetadata;


	public PublisherOffer(UserMetadata publisherMetadata) {
		this.publisherMetadata = publisherMetadata;
	}


	public UserMetadata getPublisher() {
		return publisherMetadata;
	}


	@Override
	public DecisionType getType() {
		return DecisionType.publisherOffer;
	}

}

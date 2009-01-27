package deus.model.attention.decision;

import deus.model.attention.AttentionElementType;
import deus.model.user.UserMetadata;

public class PublisherOffer extends ConnectionDecisionToMake {

	private final UserMetadata publisherMetadata;


	public PublisherOffer(UserMetadata publisherMetadata) {
		this.publisherMetadata = publisherMetadata;
	}


	public UserMetadata getPublisherMetadata() {
		return publisherMetadata;
	}


	@Override
	public DecisionType getType() {
		return DecisionType.publisherOffer;
	}


	@Override
	public String getCatchphare() {
		//I18N
		return "Your Contact "+getPublisherMetadata().getFullName()+" offers subscription";
	}

}

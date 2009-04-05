package deus.model.attention.publication.connection.establish.pubinit;

import deus.model.attention.DecisionType;
import deus.model.attention.publication.connection.ConnectionDecisionToMake;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

// FIXME: rename it to OfferSubscriptionPlea
public class PublisherOffer extends ConnectionDecisionToMake {

	private final UserId publisherId;
	private final UserMetadata publisherMetadata;


	public PublisherOffer(UserId publisherId, UserMetadata publisherMetadata) {
		this.publisherId = publisherId;
		this.publisherMetadata = publisherMetadata;
	}


	public UserId getPublisherId() {
		return publisherId;
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
		// I18N
		return "Your Contact " + getPublisherMetadata().getFullName() + " offers subscription";
	}

}
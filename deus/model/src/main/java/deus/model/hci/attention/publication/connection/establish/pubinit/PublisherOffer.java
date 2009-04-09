package deus.model.hci.attention.publication.connection.establish.pubinit;

import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.hci.attention.DecisionType;
import deus.model.hci.attention.publication.connection.ConnectionDecisionToMake;

// FIXME: rename it to OfferSubscriptionPlea
public class PublisherOffer extends ConnectionDecisionToMake {

	private final PublisherId publisherId;
	private final UserMetadata publisherMetadata;


	public PublisherOffer(PublisherId publisherId, UserMetadata publisherMetadata) {
		this.publisherId = publisherId;
		this.publisherMetadata = publisherMetadata;
	}


	public PublisherId getPublisherId() {
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

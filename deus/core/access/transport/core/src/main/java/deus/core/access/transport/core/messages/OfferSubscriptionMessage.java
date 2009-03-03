package deus.core.access.transport.core.messages;

import deus.model.user.UserMetadata;

public class OfferSubscriptionMessage extends InviteSubscriberMessage {

	private final UserMetadata publisherMetadata;


	public OfferSubscriptionMessage(UserMetadata publisherMetadata) {
		this.publisherMetadata = publisherMetadata;
	}


	public UserMetadata getPublisherMetadata() {
		return publisherMetadata;
	}

}

package deus.core.access.transport.core.sending.command.impl;

import deus.core.access.transport.core.messages.InviteSubscriberMessage;
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

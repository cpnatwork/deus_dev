package deus.core.access.transfer.common.messages.publication.connection.establish.subscribe;

import deus.model.common.user.UserMetadata;

/**
 * Command, issued by the informationConsumer to initiate a request for a subscription.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public final class RequestSubscriptionMessage extends SubscribeToPublisherMessage {

	private final UserMetadata subscriberMetadata;


	public RequestSubscriptionMessage(UserMetadata subscriberMetadata) {
		super();
		this.subscriberMetadata = subscriberMetadata;
	}


	public UserMetadata getSubscriberMetadata() {
		return subscriberMetadata;
	}

}

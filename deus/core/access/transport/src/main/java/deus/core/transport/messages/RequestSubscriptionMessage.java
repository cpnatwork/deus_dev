package deus.core.transport.messages;

import deus.model.user.UserMetadata;

/**
 * Command, issued by the subscriber to initiate a request for a subscription.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public final class RequestSubscriptionMessage extends SubscribeMessage {

	private final UserMetadata subscriberMetadata;


	public RequestSubscriptionMessage(UserMetadata subscriberMetadata) {
		super();
		this.subscriberMetadata = subscriberMetadata;
	}


	public UserMetadata getSubscriberMetadata() {
		return subscriberMetadata;
	}

}

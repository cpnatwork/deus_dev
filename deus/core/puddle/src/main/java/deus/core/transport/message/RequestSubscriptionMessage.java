package deus.core.transport.message;

import deus.model.user.UserMetadata;

/**
 * Command, issued by the subscriber to initiate a request for a subscription.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public final class RequestSubscriptionMessage extends SubscribeMessage {

	private final UserMetadata senderMetadata;


	public RequestSubscriptionMessage(UserMetadata senderMetadata) {
		super();
		this.senderMetadata = senderMetadata;
	}


	public UserMetadata getSenderMetadata() {
		return senderMetadata;
	}

}

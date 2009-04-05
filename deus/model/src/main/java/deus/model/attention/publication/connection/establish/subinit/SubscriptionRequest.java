package deus.model.attention.publication.connection.establish.subinit;

import deus.model.attention.DecisionType;
import deus.model.attention.publication.connection.ConnectionDecisionToMake;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public class SubscriptionRequest extends ConnectionDecisionToMake {

	private final UserId subscriberId;
	private final UserMetadata subscriberMetadata;


	public SubscriptionRequest(UserId subscriberId, UserMetadata subscriberMetadata) {
		this.subscriberId = subscriberId;
		this.subscriberMetadata = subscriberMetadata;
	}


	public UserId getSubscriberId() {
		return subscriberId;
	}


	public UserMetadata getSubscriberMetadata() {
		return subscriberMetadata;
	}


	@Override
	public DecisionType getType() {
		return DecisionType.subscriberRequest;
	}


	@Override
	public String getCatchphare() {
		// I18N
		return "Your Contact " + getSubscriberMetadata().getFullName() + " requests subscription";
	}

}

package deus.model.hci.attention.publication.connection.establish.subinit;

import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.SubscriberId;
import deus.model.hci.attention.DecisionType;
import deus.model.hci.attention.publication.connection.ConnectionDecisionToMake;

public class SubscriptionRequest extends ConnectionDecisionToMake {

	private final SubscriberId subscriberId;
	private final UserMetadata subscriberMetadata;


	public SubscriptionRequest(SubscriberId subscriberId, UserMetadata subscriberMetadata) {
		this.subscriberId = subscriberId;
		this.subscriberMetadata = subscriberMetadata;
	}


	public SubscriberId getSubscriberId() {
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

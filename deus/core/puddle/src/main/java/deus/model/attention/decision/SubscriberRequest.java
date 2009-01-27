package deus.model.attention.decision;

import deus.model.user.UserMetadata;

public class SubscriberRequest extends ConnectionDecisionToMake {

	private final UserMetadata subscriberMetadata;


	public SubscriberRequest(UserMetadata subscriberMetadata) {
		this.subscriberMetadata = subscriberMetadata;
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
		//I18N
		return "Your Contact "+getSubscriberMetadata().getFullName()+" requests subscription";
	}


}

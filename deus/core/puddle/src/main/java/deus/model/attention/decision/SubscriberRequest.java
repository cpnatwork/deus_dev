package deus.model.attention.decision;

import deus.model.pub.SubscriberMetadata;

public class SubscriberRequest extends ConnectionDecisionToMake {

	private final SubscriberMetadata subscriberMetadata;


	public SubscriberRequest(SubscriberMetadata subscriberMetadata) {
		this.subscriberMetadata = subscriberMetadata;
	}


	public SubscriberMetadata getSubscriberMetadata() {
		return subscriberMetadata;
	}


	@Override
	public DecisionType getType() {
		return DecisionType.subscriberRequest;
	}


}

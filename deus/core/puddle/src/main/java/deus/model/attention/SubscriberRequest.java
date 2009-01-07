package deus.model.attention;

import deus.model.contactprofile.proj.party.PartyId;
import deus.model.pub.SubscriberMetadata;

public class SubscriberRequest<T extends PartyId> extends DecisionToMake {

	private final SubscriberMetadata<T> subscriber;
	private boolean accepted;
	
	public SubscriberRequest(SubscriberMetadata<T> subscriber) {
		this.subscriber = subscriber;
	}

	public SubscriberMetadata<T> getSubscriber() {
		return subscriber;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
		
}

package deus.model.attention;

import deus.model.dossier.proj.party.PartyId;
import deus.model.pub.SubscriberMetadata;

public class SubscriberRequest<Id extends PartyId> extends DecisionToMake {

	private final SubscriberMetadata<Id> subscriber;
	private boolean accepted;
	
	public SubscriberRequest(SubscriberMetadata<Id> subscriber) {
		this.subscriber = subscriber;
	}

	public SubscriberMetadata<Id> getSubscriber() {
		return subscriber;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
		
}

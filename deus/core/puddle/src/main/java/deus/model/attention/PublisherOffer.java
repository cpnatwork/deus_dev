package deus.model.attention;

import deus.model.dossier.proj.party.PartyId;
import deus.model.sub.PublisherMetadata;

public class PublisherOffer<Id extends PartyId> extends DecisionToMake {

	private final PublisherMetadata<Id> publisher;
	private boolean confirmed;


	public PublisherOffer(PublisherMetadata<Id> publisher) {
		this.publisher = publisher;
	}


	public PublisherMetadata<Id> getPublisher() {
		return publisher;
	}


	public boolean isConfirmed() {
		return confirmed;
	}


	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

}

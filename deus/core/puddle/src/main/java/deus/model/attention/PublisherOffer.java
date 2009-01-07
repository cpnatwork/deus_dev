package deus.model.attention;

import deus.model.contactprofile.proj.party.PartyId;
import deus.model.sub.PublisherMetadata;

public class PublisherOffer<T extends PartyId> extends DecisionToMake {

	private final PublisherMetadata<T> publisher;
	private boolean confirmed;


	public PublisherOffer(PublisherMetadata<T> publisher) {
		this.publisher = publisher;
	}


	public PublisherMetadata<T> getPublisher() {
		return publisher;
	}


	public boolean isConfirmed() {
		return confirmed;
	}


	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

}

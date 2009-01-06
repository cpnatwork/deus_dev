package dacus.model.pub;

import dacus.model.contactprofile.proj.party.PartyId;

public class SubscriberMetadata<T extends PartyId> {

	private T subscriberId;
	private String subscriberFullName;
	// private ShareSet subscriberShareSet;
	
	
	public T getSubscriberId() {
		return subscriberId;
	}


	public void setSubscriberId(T subscriberId) {
		this.subscriberId = subscriberId;
	}


	public String getSubscriberFullName() {
		return subscriberFullName;
	}


	public void setSubscriberFullName(String subscriberFullName) {
		this.subscriberFullName = subscriberFullName;
	}

}

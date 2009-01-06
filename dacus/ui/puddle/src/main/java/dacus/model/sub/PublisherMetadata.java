package dacus.model.sub;

import dacus.model.contactprofile.proj.party.PartyId;

public class PublisherMetadata<T extends PartyId> {

	private T publisherId;
	private String publisherFullName;


	public T getPublisherId() {
		return publisherId;
	}


	public void setPublisherId(T publisherId) {
		this.publisherId = publisherId;
	}


	public String getPublisherFullName() {
		return publisherFullName;
	}


	public void setPublisherFullName(String publisherFullName) {
		this.publisherFullName = publisherFullName;
	}

}

package deus.model.dossier;

import java.util.List;

import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;

public abstract class ForeignInformationFile<Id extends UserId, ContentType> {

	private PublisherMetadata<Id> publisherMetadata;

	private List<ContentType> digitalCards;


	public PublisherMetadata<Id> getPublisherMetadata() {
		return publisherMetadata;
	}


	public void setPublisherMetadata(PublisherMetadata<Id> publisherMetadata) {
		this.publisherMetadata = publisherMetadata;
	}

}

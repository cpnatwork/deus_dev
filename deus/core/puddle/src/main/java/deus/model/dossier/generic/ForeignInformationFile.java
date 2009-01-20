package deus.model.dossier.generic;

import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;

/**
 * The view of a personal information file (PIF), that resides on the subscriber side. This file is sent by the
 * publisher to its subscribers.
 * 
 * Abbreviation: FIF
 * 
 * @see PersonalInformationFile
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 * @param <Id>	the type of the publisher ID
 * @param <ContentType>	the content type of this FIF
 */
public abstract class ForeignInformationFile<Id extends UserId, ContentType> {

	private PublisherMetadata<Id> publisherMetadata;

	private ContentType content;


	public PublisherMetadata<Id> getPublisherMetadata() {
		return publisherMetadata;
	}


	public void setPublisherMetadata(PublisherMetadata<Id> publisherMetadata) {
		this.publisherMetadata = publisherMetadata;
	}

}

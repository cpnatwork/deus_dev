package deus.model.dossier.generic;

import deus.model.sub.PublisherMetadata;

/**
 * The view of a personal information file (PIF), that resides on the subscriber side. This file is sent by the
 * publisher to its subscribers.
 * 
 * Abbreviation: FIF
 * 
 * @see PersonalInformationFile
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 */
public abstract class ForeignInformationFile {

	private PublisherMetadata publisherMetadata;


	public PublisherMetadata getPublisherMetadata() {
		return publisherMetadata;
	}


	public void setPublisherMetadata(PublisherMetadata publisherMetadata) {
		this.publisherMetadata = publisherMetadata;
	}

}

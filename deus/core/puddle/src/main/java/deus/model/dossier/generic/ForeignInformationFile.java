package deus.model.dossier.generic;

import deus.model.user.UserMetadata;

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

	private UserMetadata publisherMetadata;


	public UserMetadata getPublisherMetadata() {
		return publisherMetadata;
	}


	public void setPublisherMetadata(UserMetadata publisherMetadata) {
		this.publisherMetadata = publisherMetadata;
	}

}

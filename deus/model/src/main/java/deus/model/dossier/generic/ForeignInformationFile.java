package deus.model.dossier.generic;

import deus.model.user.UserMetadata;
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
 */
public abstract class ForeignInformationFile {

	private UserId publisherId;

	private UserMetadata publisherMetadata;


	public UserId getPublisherId() {
		return publisherId;
	}


	public void setPublisherId(UserId publisherId) {
		this.publisherId = publisherId;
	}


	public UserMetadata getPublisherMetadata() {
		return publisherMetadata;
	}


	public void setPublisherMetadata(UserMetadata publisherMetadata) {
		this.publisherMetadata = publisherMetadata;
	}

}

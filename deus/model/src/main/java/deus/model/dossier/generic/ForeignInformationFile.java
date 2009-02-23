package deus.model.dossier.generic;

import java.util.Set;

import deus.model.dossier.DigitalCard;
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
public class ForeignInformationFile extends InformationFile {

	private final UserId publisherId;

	private final UserMetadata publisherMetadata;

	public ForeignInformationFile(UserId publisherId, UserMetadata publisherMetadata, Set<DigitalCard> digitalCards) {
		super(digitalCards);
		this.publisherId = publisherId;
		this.publisherMetadata = publisherMetadata;
	}


	public UserId getPublisherId() {
		return publisherId;
	}


	public UserMetadata getPublisherMetadata() {
		return publisherMetadata;
	}

}

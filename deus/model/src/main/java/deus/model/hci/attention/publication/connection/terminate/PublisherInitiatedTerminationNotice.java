package deus.model.hci.attention.publication.connection.terminate;

import deus.model.common.user.UserMetadata;

public class PublisherInitiatedTerminationNotice extends TerminationNotice {

	private final UserMetadata publisherMetadata;


	public PublisherInitiatedTerminationNotice(UserMetadata publisherMetadata) {
		this.publisherMetadata = publisherMetadata;
	}


	public UserMetadata getPublisherMetadata() {
		return publisherMetadata;
	}


	@Override
	public String getCatchphare() {
		// TODO Auto-generated method stub
		return null;
	}

}

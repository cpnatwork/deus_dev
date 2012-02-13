package deus.model.hci.attention.publication.connection.establish.subinit;

import deus.model.common.user.UserMetadata;
import deus.model.hci.attention.publication.connection.ConnectionNotice;

public abstract class SubscriberInitiatedConnectionNotice extends ConnectionNotice {

	private final UserMetadata publisherMetadata;


	public SubscriberInitiatedConnectionNotice(UserMetadata publisherMetadata) {
		super();
		this.publisherMetadata = publisherMetadata;
	}


	public UserMetadata getPublisherMetadata() {
		return publisherMetadata;
	}

}

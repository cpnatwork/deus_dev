package deus.model.barker.attention.publication.connection.establish.subinit;

import deus.model.barker.attention.publication.connection.ConnectionNotice;
import deus.model.common.user.UserMetadata;

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

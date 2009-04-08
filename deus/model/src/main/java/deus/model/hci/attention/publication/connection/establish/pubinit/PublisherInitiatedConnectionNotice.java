package deus.model.hci.attention.publication.connection.establish.pubinit;

import deus.model.common.user.UserMetadata;
import deus.model.hci.attention.publication.connection.ConnectionNotice;

public abstract class PublisherInitiatedConnectionNotice extends ConnectionNotice {

	private final UserMetadata subscriberMetadata;


	public PublisherInitiatedConnectionNotice(UserMetadata subscriberMetadata) {
		super();
		this.subscriberMetadata = subscriberMetadata;
	}


	public UserMetadata getSubscriberMetadata() {
		return subscriberMetadata;
	}

}

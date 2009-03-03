package deus.model.attention.notice;

import deus.model.user.UserMetadata;

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

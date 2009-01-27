package deus.model.attention.notice;

import deus.model.user.UserMetadata;

public abstract class PublisherSentNotice extends ConnectionNotice {

	private final UserMetadata publisherMetadata;


	public PublisherSentNotice(UserMetadata publisherMetadata) {
		super();
		this.publisherMetadata = publisherMetadata;
	}


	public UserMetadata getPublisherMetadata() {
		return publisherMetadata;
	}
}

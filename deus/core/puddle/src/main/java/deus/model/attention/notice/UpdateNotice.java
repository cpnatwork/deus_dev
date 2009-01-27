package deus.model.attention.notice;

import deus.model.user.UserMetadata;

public class UpdateNotice extends Notice {

	private final UserMetadata publisherMetadata;


	public UpdateNotice(UserMetadata publisherMetadata) {
		super();
		this.publisherMetadata = publisherMetadata;
	}


	public UserMetadata getPublisherMetadata() {
		return publisherMetadata;
	}
	
}

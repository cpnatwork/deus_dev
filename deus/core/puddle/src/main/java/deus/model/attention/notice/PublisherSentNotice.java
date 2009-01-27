package deus.model.attention.notice;

import deus.model.user.UserMetadata;

public abstract class PublisherSentNotice extends ConnectionNotice {

	private final UserMetadata publiserMetadata;


	public PublisherSentNotice(UserMetadata publiserMetadata) {
		super();
		this.publiserMetadata = publiserMetadata;
	}


	public UserMetadata getPubliserMetadata() {
		return publiserMetadata;
	}
}

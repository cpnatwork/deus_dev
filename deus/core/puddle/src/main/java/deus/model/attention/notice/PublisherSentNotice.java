package deus.model.attention.notice;

import deus.model.sub.PublisherMetadata;

public abstract class PublisherSentNotice extends ConnectionNotice {

	private final PublisherMetadata publiserMetadata;


	public PublisherSentNotice(PublisherMetadata publiserMetadata) {
		super();
		this.publiserMetadata = publiserMetadata;
	}


	public PublisherMetadata getPubliserMetadata() {
		return publiserMetadata;
	}
}

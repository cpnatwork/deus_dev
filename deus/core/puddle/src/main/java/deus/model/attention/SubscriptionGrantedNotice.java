package deus.model.attention;

import deus.model.sub.PublisherMetadata;

public class SubscriptionGrantedNotice extends ConnectionNotice {

	private final PublisherMetadata publiserMetadata;


	public SubscriptionGrantedNotice(PublisherMetadata publiserMetadata) {
		super();
		this.publiserMetadata = publiserMetadata;
	}


	public PublisherMetadata getPubliserMetadata() {
		return publiserMetadata;
	}

}

package deus.model.attention;

import deus.model.sub.PublisherMetadata;

public class UpdateNotice extends Notice {

	private final PublisherMetadata publiserMetadata;


	public UpdateNotice(PublisherMetadata publiserMetadata) {
		super();
		this.publiserMetadata = publiserMetadata;
	}


	public PublisherMetadata getPubliserMetadata() {
		return publiserMetadata;
	}
	
}

package deus.core.publisher.stub.impl;

import deus.core.publisher.stub.PublisherStub;
import deus.model.user.id.UserId;


public abstract class AbstractPublisherStub implements PublisherStub {

	private final UserId publisherId;


	public AbstractPublisherStub(UserId publisherId) {
		super();
		this.publisherId = publisherId;
	}


	@Override
	public UserId getPublisherId() {
		return publisherId;
	}

}

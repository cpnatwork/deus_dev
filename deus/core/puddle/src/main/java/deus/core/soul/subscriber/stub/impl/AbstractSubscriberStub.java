package deus.core.soul.subscriber.stub.impl;


import deus.core.soul.subscriber.stub.SubscriberStub;
import deus.model.user.id.UserId;

public abstract class AbstractSubscriberStub implements SubscriberStub {

	private final UserId subscriberId;


	public AbstractSubscriberStub(UserId subscriberId) {
		super();
		this.subscriberId = subscriberId;
	}


	@Override
	public UserId getSubscriberId() {
		return subscriberId;
	}

}
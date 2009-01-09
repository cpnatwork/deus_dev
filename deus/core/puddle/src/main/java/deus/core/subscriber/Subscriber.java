package deus.core.subscriber;

import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.UserId;


public interface Subscriber<Id extends UserId> extends SubscriberStub<Id> {

	public abstract SubscriberMetadata<Id> getSubscriberMetadata();

}
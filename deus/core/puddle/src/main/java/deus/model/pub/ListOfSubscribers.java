package deus.model.pub;

import java.util.List;

import deus.model.user.id.UserId;


public interface ListOfSubscribers<Id extends UserId> extends List<SubscriberMetadata<Id>> {
	
}
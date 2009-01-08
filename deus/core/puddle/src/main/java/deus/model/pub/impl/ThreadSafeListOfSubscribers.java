package deus.model.pub.impl;

import java.util.Vector;

import deus.model.pub.ListOfSubscribers;
import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.UserId;

public class ThreadSafeListOfSubscribers<Id extends UserId> extends Vector<SubscriberMetadata<Id>> implements ListOfSubscribers<Id> {

	private static final long serialVersionUID = -5115372700101022103L;

}

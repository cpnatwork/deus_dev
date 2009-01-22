package deus.model.pub.impl;

import java.util.Vector;

import deus.model.pub.ListOfSubscribers;
import deus.model.pub.SubscriberMetadata;

public class ThreadSafeListOfSubscribers extends Vector<SubscriberMetadata> implements ListOfSubscribers {

	private static final long serialVersionUID = -5115372700101022103L;

}

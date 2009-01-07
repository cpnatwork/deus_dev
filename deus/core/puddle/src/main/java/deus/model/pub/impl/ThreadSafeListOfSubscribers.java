package deus.model.pub.impl;

import java.util.Vector;

import deus.model.contactprofile.proj.party.PartyId;
import deus.model.pub.ListOfSubscribers;
import deus.model.pub.SubscriberMetadata;

public class ThreadSafeListOfSubscribers<T extends PartyId> extends Vector<SubscriberMetadata<T>> implements ListOfSubscribers<T> {

	private static final long serialVersionUID = -5115372700101022103L;

}

package dacus.model.pub.impl;

import java.util.Vector;

import dacus.model.contactprofile.proj.party.PartyId;
import dacus.model.pub.ListOfSubscribers;
import dacus.model.pub.SubscriberMetadata;

public class ThreadSafeListOfSubscribers<T extends PartyId> extends Vector<SubscriberMetadata<T>> implements ListOfSubscribers<T> {

	private static final long serialVersionUID = -5115372700101022103L;

}

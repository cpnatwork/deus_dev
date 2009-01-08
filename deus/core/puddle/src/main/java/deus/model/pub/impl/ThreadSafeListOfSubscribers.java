package deus.model.pub.impl;

import java.util.Vector;

import deus.model.dossier.proj.party.PartyId;
import deus.model.pub.ListOfSubscribers;
import deus.model.pub.SubscriberMetadata;

public class ThreadSafeListOfSubscribers<Id extends PartyId> extends Vector<SubscriberMetadata<Id>> implements ListOfSubscribers<Id> {

	private static final long serialVersionUID = -5115372700101022103L;

}

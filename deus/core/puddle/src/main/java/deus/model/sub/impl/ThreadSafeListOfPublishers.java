package deus.model.sub.impl;

import java.util.Vector;

import deus.model.contactprofile.proj.party.PartyId;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.PublisherMetadata;

public class ThreadSafeListOfPublishers<T extends PartyId> extends Vector<PublisherMetadata<T>> implements ListOfPublishers<T> {

	private static final long serialVersionUID = -5223112352758013300L;

}

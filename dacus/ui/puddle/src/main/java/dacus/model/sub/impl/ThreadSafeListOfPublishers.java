package dacus.model.sub.impl;

import java.util.Vector;

import dacus.model.contactprofile.proj.party.PartyId;
import dacus.model.sub.ListOfPublishers;
import dacus.model.sub.PublisherMetadata;

public class ThreadSafeListOfPublishers<T extends PartyId> extends Vector<PublisherMetadata<T>> implements ListOfPublishers<T> {

	private static final long serialVersionUID = -5223112352758013300L;

}

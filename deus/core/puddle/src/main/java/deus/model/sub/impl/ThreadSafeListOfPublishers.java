package deus.model.sub.impl;

import java.util.Vector;

import deus.model.dossier.proj.party.PartyId;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.PublisherMetadata;

public class ThreadSafeListOfPublishers<Id extends PartyId> extends Vector<PublisherMetadata<Id>> implements ListOfPublishers<Id> {

	private static final long serialVersionUID = -5223112352758013300L;

}

package deus.model.sub.impl;

import java.util.Vector;

import deus.model.sub.ListOfPublishers;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;

public class ThreadSafeListOfPublishers<Id extends UserId> extends Vector<PublisherMetadata<Id>> implements ListOfPublishers<Id> {

	private static final long serialVersionUID = -5223112352758013300L;

}

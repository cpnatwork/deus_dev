package deus.model.sub.impl;

import java.util.Vector;

import deus.model.sub.ListOfPublishers;
import deus.model.sub.PublisherMetadata;

public class ThreadSafeListOfPublishers extends Vector<PublisherMetadata> implements ListOfPublishers {

	private static final long serialVersionUID = -5223112352758013300L;

}

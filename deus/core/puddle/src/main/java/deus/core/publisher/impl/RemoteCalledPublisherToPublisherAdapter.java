package deus.core.publisher.impl;

import deus.core.publisher.Publisher;
import deus.core.publisher.RemoteCalledPublisher;
import deus.model.pub.ListOfSubscribers;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;

/**
 * Delegates all methods of <code>RemoteCalledPublisher</code> to a delegate of type <code>RemoteCalledPublisher</code>,
 * the rest of the methods of <code>Publisher</code> are delegated to the second delegate, which is of type
 * <code>Publisher</code>.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public class RemoteCalledPublisherToPublisherAdapter implements Publisher {

	private final RemoteCalledPublisher remoteCalledPublisher;
	private final Publisher publisher;


	public RemoteCalledPublisherToPublisherAdapter(RemoteCalledPublisher remoteCalledPublisher, Publisher publisher) {
		super();
		this.remoteCalledPublisher = remoteCalledPublisher;
		this.publisher = publisher;
	}


//	+++ METHODS OF REMOTE CALLED PUBLISHER ++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@Override
	public void addObserver(SubscriberMetadata subscriberMetadata) {
		remoteCalledPublisher.addObserver(subscriberMetadata);
	}


	@Override
	public void deleteObserver(SubscriberMetadata subscriberMetadata) {
		remoteCalledPublisher.deleteObserver(subscriberMetadata);
	}

//	+++ METHODS OF PUBLISHER ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@Override
	public int countObservers() {
		return publisher.countObservers();
	}


	@Override
	public void deleteObservers() {
		publisher.deleteObservers();
	}


	@Override
	public ListOfSubscribers getListOfSubscribers() {
		return publisher.getListOfSubscribers();
	}


	@Override
	public PublisherMetadata getPublisherMetadata() {
		return publisher.getPublisherMetadata();
	}


	@Override
	public void notifyObservers() {
		publisher.notifyObservers();
	}


	@Override
	public void notifyObservers(Object change) {
		publisher.notifyObservers(change);
	}

}

package deus.core.soul.publisher.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import deus.core.soul.common.PublisherCommandExecutor;
import deus.core.soul.publisher.Publisher;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.pub.ListOfSubscribers;
import deus.model.pub.LosEntry;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Configurable
public class PublisherImpl implements Publisher {

	private final UserMetadata publisherMetadata;
	
	@Autowired
	private PublisherCommandExecutor publisherCommandExecutor;

	protected final ListOfSubscribers listOfSubscribers;


	public PublisherImpl(ListOfSubscribers listOfSubscribers, UserMetadata publisherMetadata) {
		super();
		this.listOfSubscribers = listOfSubscribers;

		this.publisherMetadata = publisherMetadata;
	}

	@Override
	public synchronized void addObserver(UserId subscriberId, UserMetadata subscriberMetadata) {
		if (!listOfSubscribers.containsKey(subscriberId)) {
			LosEntry entry = new LosEntry();
			entry.setSubscriberMetadata(subscriberMetadata);
			listOfSubscribers.put(subscriberId, entry);
		}
		else
			throw new IllegalArgumentException("cannot add subscriber, it has already been added!");
	}


	@Override
	public synchronized void deleteObserver(UserId subscriberId) {
		if(!listOfSubscribers.containsKey(subscriberId))
			throw new IllegalArgumentException("cannot remove subscriber, that has not been added yet!");
		listOfSubscribers.remove(subscriberId);
	}


	@Override
	public synchronized void deleteObservers() {
		listOfSubscribers.clear();
	}


	@Override
	public synchronized int countObservers() {
		return listOfSubscribers.size();
	}


	@Override
	public void notifyObservers() {
		notifyObservers(null);
	}


	@Override
	public void notifyObservers(ForeignInformationFile change) {
		/*
		 * a temporary array buffer, used as a snapshot of the state of current Observers.
		 */
		Object[] arrLocal;

		synchronized (this) {
			/*
			 * We don't want the Observer doing callbacks into arbitrary code while holding its own Monitor. The code
			 * where we extract each Observable from the Vector and store the state of the Observer needs
			 * synchronization, but notifying observers does not (should not). The worst result of any potential
			 * race-condition here is that: 1) a newly-added Observer will miss a notification in progress 2) a recently
			 * unregistered Observer will be wrongly notified when it doesn't care
			 */
			arrLocal = listOfSubscribers.keySet().toArray();
		}

		for (int i = arrLocal.length - 1; i >= 0; i--) {
			// TODO: think about publishing using multiple threads
			UserId subscriberId = (UserId) arrLocal[i];
			
			publisherCommandExecutor.update(subscriberId, publisherMetadata.getUserId(), change);
		}
	}


	@Override
	public ListOfSubscribers getListOfSubscribers() {
		return listOfSubscribers;
	}


	@Override
	public UserMetadata getPublisherMetadata() {
		return publisherMetadata;
	}

}

package deus.core.soul.publisher.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import deus.core.access.transport.core.sending.command.PublisherCommandSender;
import deus.core.soul.publisher.Publisher;
import deus.model.dossier.DigitalCard;
import deus.model.pub.ListOfSubscribers;
import deus.model.pub.LosEntry;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Configurable
public class PublisherImpl implements Publisher {
	
	private final Logger logger = LoggerFactory.getLogger(PublisherImpl.class);
	
	private final UserId publisherId;
	
	@Autowired
	private PublisherCommandSender publisherCommandSender;

	protected final ListOfSubscribers listOfSubscribers;


	public PublisherImpl(ListOfSubscribers listOfSubscribers, UserId publisherId) {
		super();
		this.listOfSubscribers = listOfSubscribers;

		this.publisherId = publisherId;
	}

	@Override
	public synchronized void addObserver(UserId subscriberId, UserMetadata subscriberMetadata) {
		logger.trace("adding subscriber {}", subscriberId);
		
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
		logger.trace("removing subscriber {}", subscriberId);
		
		if(!listOfSubscribers.containsKey(subscriberId))
			throw new IllegalArgumentException("cannot remove subscriber, that has not been added yet!");
		listOfSubscribers.remove(subscriberId);
	}


	@Override
	public synchronized void deleteObservers() {
		logger.trace("removing all subscribers");
		
		listOfSubscribers.clear();
	}


	@Override
	public synchronized int countObservers() {
		return listOfSubscribers.size();
	}


	@Override
	public void notifyObservers(DigitalCard digitalCard) {
		logger.trace("notifying subscribers of change {}", digitalCard);
		
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
			
			publisherCommandSender.update(subscriberId, publisherId, digitalCard);
		}
	}


	@Override
	public ListOfSubscribers getListOfSubscribers() {
		return listOfSubscribers;
	}


	@Override
	public UserId getPublisherId() {
		return publisherId;
	}

}

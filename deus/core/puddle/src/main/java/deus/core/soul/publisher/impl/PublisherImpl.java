package deus.core.soul.publisher.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.storage.pub.api.PubDao;
import deus.core.access.transport.core.sending.command.PublisherCommandSender;
import deus.core.soul.publisher.Publisher;
import deus.model.dossier.DigitalCard;
import deus.model.pub.ListOfSubscribers;
import deus.model.pub.LosEntry;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component
@Qualifier("target")
public class PublisherImpl implements Publisher {
	
	private final Logger logger = LoggerFactory.getLogger(PublisherImpl.class);
	
	@Autowired
	private PublisherCommandSender publisherCommandSender;
	
	@Autowired
	private PubDao pubDao;

	@Override
	public synchronized void addSubscriber(UserId publisherId, UserId subscriberId, UserMetadata subscriberMetadata) {
		logger.trace("adding subscriber {}", subscriberId);

		ListOfSubscribers listOfSubscribers = pubDao.getListOfSubscribers(publisherId);
		
		if (listOfSubscribers.containsKey(subscriberId))
			throw new IllegalArgumentException("cannot add subscriber, it has already been added!");
	
		LosEntry entry = new LosEntry();
		entry.setSubscriberMetadata(subscriberMetadata);
		listOfSubscribers.put(subscriberId, entry);
		
		// FIXME: store by using dao.store():
	}


	@Override
	public synchronized void deleteSubscriber(UserId publisherId, UserId subscriberId) {
		logger.trace("removing subscriber {}", subscriberId);

		ListOfSubscribers listOfSubscribers = pubDao.getListOfSubscribers(publisherId);
		
		if(!listOfSubscribers.containsKey(subscriberId))
			throw new IllegalArgumentException("cannot remove subscriber, that has not been added yet!");
		listOfSubscribers.remove(subscriberId);
		
		// FIXME: store by using dao.store():
	}


	@Override
	public synchronized void deleteSubscribers(UserId publisherId) {
		logger.trace("removing all subscribers");

		ListOfSubscribers listOfSubscribers = pubDao.getListOfSubscribers(publisherId);
		
		listOfSubscribers.clear();
		
		// FIXME: store by using dao.store():
	}


	@Override
	public synchronized int countSubscribers(UserId publisherId) {
		ListOfSubscribers listOfSubscribers = pubDao.getListOfSubscribers(publisherId);
		
		return listOfSubscribers.size();
	}


	@Override
	public void notifySubscribers(UserId publisherId, DigitalCard digitalCard) {
		logger.trace("notifying subscribers of change {}", digitalCard);
		
		ListOfSubscribers listOfSubscribers = pubDao.getListOfSubscribers(publisherId);
		
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


	// FIXME: think about returning a DTO to the frontend here
	@Override
	public ListOfSubscribers getListOfSubscribers(UserId publisherId) {
		ListOfSubscribers listOfSubscribers = pubDao.getListOfSubscribers(publisherId);
		
		return listOfSubscribers;
	}

}

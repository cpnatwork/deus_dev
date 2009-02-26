package deus.core.soul.publisher.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.pub.LosDoRep;
import deus.core.access.storage.api.pub.LosEntryDoRep;
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
	private LosEntryDoRep losEntryDoRep;

	@Autowired
	private LosDoRep losDoRep;


	// FIXME: think about returning a DTO to the frontend here
	@Override
	public ListOfSubscribers getListOfSubscribers(UserId publisherId) {
		return losDoRep.getByNaturalId(publisherId);
	}


	@Override
	public synchronized void addSubscriber(UserId publisherId, UserId subscriberId, UserMetadata subscriberMetadata) {
		logger.trace("adding subscriber {}", subscriberId);

		if (losEntryDoRep.containsEntity(subscriberId, publisherId))
			throw new IllegalArgumentException("cannot add subscriber, it has already been added!");

		LosEntry entry = new LosEntry(publisherId);
		entry.setSubscriberMetadata(subscriberMetadata);

		losEntryDoRep.addNewEntity(publisherId, entry);
	}


	@Override
	public synchronized void deleteSubscriber(UserId publisherId, UserId subscriberId) {
		logger.trace("removing subscriber {}", subscriberId);

		if (!losEntryDoRep.containsEntity(subscriberId, publisherId))
			throw new IllegalArgumentException("cannot remove subscriber, that has not been added yet!");

		losEntryDoRep.deleteByNaturalId(subscriberId, publisherId);
	}



	@Override
	public synchronized void notifySubscriber(UserId publisherId, UserId subscriberId, DigitalCard digitalCard) {
		logger.trace("notifying subscribers of change {}", digitalCard);
		
		LosEntry losEntry = losEntryDoRep.getByNaturalId(subscriberId, publisherId);
		
		publisherCommandSender.update(losEntry.getSubscriberId(), publisherId, digitalCard);
	}
	

	@Override
	public void notifySubscribers(UserId publisherId, DigitalCard digitalCard) {
		logger.trace("notifying subscribers of change {}", digitalCard);

		ListOfSubscribers listOfSubscribers = losDoRep.getByNaturalId(publisherId);

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
			LosEntry losEntry = (LosEntry) arrLocal[i];

			publisherCommandSender.update(losEntry.getSubscriberId(), publisherId, digitalCard);
		}
	}

}

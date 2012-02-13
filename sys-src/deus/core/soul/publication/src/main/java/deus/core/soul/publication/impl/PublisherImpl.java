package deus.core.soul.publication.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import deus.core.access.storage.api.common.user.UserMetadataDao;
import deus.core.access.storage.api.publication.LosDao;
import deus.core.access.storage.api.publication.LosEntryDao;
import deus.core.access.transfer.core.sending.command.PublisherCommandSender;
import deus.core.soul.publication.Publisher;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.publication.ListOfSubscribers;
import deus.model.publication.LosEntry;
import deus.model.publication.PublisherSideSubscriptionState;

@Named("targetedPublisher")
public class PublisherImpl implements Publisher {

	private final Logger logger = LoggerFactory.getLogger(PublisherImpl.class);

	
	@Inject
	private PublisherCommandSender publisherCommandSender;

	@Inject
	private UserMetadataDao userMetadataDao;

	@Inject
	private LosEntryDao losEntryDao;

	@Inject
	private LosDao losDao;


	// FIXME: think about returning a DTO to the frontend here
	@Override
	public ListOfSubscribers getListOfSubscribers(PublisherId publisherId) {
		return losDao.getByNaturalId(publisherId);
	}


	// +++ exported to PEER +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	@Override
	public synchronized void addSubscriber(PublisherId publisherId, SubscriberId subscriberId,
			UserMetadata subscriberMetadata) {
		logger.trace("adding informationConsumer {}", subscriberId);

		if (losEntryDao.existsByNaturalId(publisherId, subscriberId))
			throw new IllegalArgumentException("cannot add informationConsumer, it has already been added!");

		LosEntry entry = new LosEntry(subscriberId);
		entry.setSubscriberMetadata(subscriberMetadata);
		entry.setSubscriptionState(PublisherSideSubscriptionState.established);

		losEntryDao.addNewEntity(publisherId, entry);
	}


	@Override
	public synchronized void deleteSubscriber(PublisherId publisherId, SubscriberId subscriberId) {
		logger.trace("removing informationConsumer {}", subscriberId);

		if (!losEntryDao.existsByNaturalId(publisherId, subscriberId))
			throw new IllegalArgumentException("cannot remove informationConsumer, that has not been added yet!");

		losEntryDao.deleteByNaturalId(publisherId, subscriberId);
	}


	@Override
	public void subscriptionConfirmed(PublisherId publisherId, SubscriberId subscriberId) {
		logger.trace("in publisher of {}: informationConsumer {} confirmed subscription", subscriberId, publisherId);

		LosEntry entry = losEntryDao.getByNaturalId(publisherId, subscriberId);
		entry.setSubscriptionState(PublisherSideSubscriptionState.established);

		losEntryDao.updateEntity(publisherId, entry);
	}


	@Override
	public void subscriptionAbstained(PublisherId publisherId, SubscriberId subscriberId) {
		logger.trace("in publisher of {}: informationConsumer {} abstained subscription", subscriberId, publisherId);

		losEntryDao.deleteByNaturalId(publisherId, subscriberId);
	}


	// +++ exported to CLIENT +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	@Override
	public synchronized void notifySubscriber(PublisherId publisherId, SubscriberId subscriberId, DigitalCard digitalCard) {
		logger.trace("notifying subscribers of change {}", digitalCard);

		LosEntry losEntry = losEntryDao.getByNaturalId(publisherId, subscriberId);

		publisherCommandSender.update(publisherId, losEntry.getSubscriberId(), digitalCard);
	}


	@Override
	public void notifySubscribers(PublisherId publisherId, DigitalCard digitalCard) {
		logger.trace("notifying subscribers of change {}", digitalCard);

		ListOfSubscribers listOfSubscribers = losDao.getByNaturalId(publisherId);

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

			publisherCommandSender.update(publisherId, losEntry.getSubscriberId(), digitalCard);
		}
	}


	@Override
	public void inviteSubscriber(PublisherId publisherId, SubscriberId subscriberId, UserMetadata subscriberMetadata) {
		if (losEntryDao.existsByNaturalId(publisherId, subscriberId))
			throw new IllegalArgumentException("cannot offer subscription to informationConsumer (" + subscriberId
					+ ") again!");

		logger.trace("in publisher {}: offering subscription to informationConsumer {}", publisherId, subscriberId);

		LosEntry entry = new LosEntry(subscriberId);
		entry.setSubscriberMetadata(subscriberMetadata);
		entry.setSubscriptionState(PublisherSideSubscriptionState.offered);
		losEntryDao.addNewEntity(publisherId, entry);

		UserMetadata publisherMetadata = userMetadataDao.getByNaturalId(publisherId.getUserId());

		publisherCommandSender.offerSubscription(publisherId, subscriberId, publisherMetadata);
	}


	@Override
	public void cancelSubscription(PublisherId publisherId, SubscriberId subscriberId) {
		if (losEntryDao.existsByNaturalId(publisherId, subscriberId))
			throw new IllegalArgumentException("cannot cancel a subscription of informationConsumer (" + subscriberId
					+ "), that has not been added yet!");

		logger.trace("in publisher {}: canceling subscription to informationConsumer {}", publisherId, subscriberId);

		losEntryDao.deleteByNaturalId(publisherId, subscriberId);

		publisherCommandSender.cancelSubscription(publisherId, subscriberId);
	}


}

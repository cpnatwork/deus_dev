package deus.core.soul.subscription.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import deus.core.access.storage.api.common.user.UserMetadataDao;
import deus.core.access.storage.api.subscription.LopDao;
import deus.core.access.storage.api.subscription.LopEntryDao;
import deus.core.access.transfer.core.sending.command.SubscriberCommandSender;
import deus.core.soul.difgoverning.DifGovernorExportedToSubsystems;
import deus.core.soul.subscription.Subscriber;
import deus.model.common.dossier.Patch;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.subscription.ListOfPublishers;
import deus.model.subscription.LopEntry;
import deus.model.subscription.SubscriberSideSubscriptionState;

@Named("targetedSubscriber")
public class SubscriberImpl implements Subscriber {

	private final Logger logger = LoggerFactory.getLogger(SubscriberImpl.class);

	@Inject
	private UserMetadataDao userMetadataDao;

	@Inject
	private LopEntryDao lopEntryDao;

	@Inject
	private LopDao lopDao;

	@Inject
	private DifGovernorExportedToSubsystems difGovernor;

	@Inject
	private SubscriberCommandSender subscriberCommandSender;


	// +++ exported to PEER +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


	@Override
	public void noticeSubscriptionRequestGranted(SubscriberId subscriberId, PublisherId publisherId) {
		logger.trace("in informationConsumer of {}: publisher {} acknowledged subscription", subscriberId, publisherId);

		LopEntry entry = lopEntryDao.getByNaturalId(subscriberId, publisherId);
		entry.setSubscriptionState(SubscriberSideSubscriptionState.established);

		lopEntryDao.updateEntity(subscriberId, entry);
	}


	@Override
	public void noticeSubscriptionRequestDenied(SubscriberId subscriberId, PublisherId publisherId) {
		logger.trace("in informationConsumer of {}: publisher {} denied subscription", subscriberId, publisherId);

		lopEntryDao.deleteByNaturalId(subscriberId, publisherId);
	}


	@Override
	public void update(SubscriberId subscriberId, PublisherId publisherId, Patch patch) {
		if (!patch.getCpId().equals(publisherId))
			throw new IllegalArgumentException("ID of publisher does not match CP ID in passed digital card");

		logger.trace("in informationConsumer {}: updating the DIF for publisher {}", subscriberId, publisherId);

		if (!lopEntryDao.existsByNaturalId(subscriberId, publisherId))
			// FIXME: how to handle this Exception??
			;

		difGovernor.applyPatch(subscriberId, publisherId, patch);
	}
	
	
	@Override
	public void addPublisher(SubscriberId subscriberId, PublisherId publisherId, UserMetadata publisherMetadata) {
		logger.trace("in informationConsumer of {}: publisher {} added", subscriberId, publisherId);

		LopEntry entry = new LopEntry(publisherId);
		entry.setPublisherMetadata(publisherMetadata);
		entry.setSubscriptionState(SubscriberSideSubscriptionState.established);

		lopEntryDao.addNewEntity(subscriberId, entry);
	}


	@Override
	public void deletePublisher(SubscriberId subscriberId, PublisherId publisherId) {
		logger.trace("in informationConsumer of {}: publisher {} deleted", subscriberId, publisherId);

		lopEntryDao.deleteByNaturalId(subscriberId, publisherId);
	}

	

	// +++ exported to CLIENT +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


	// FIXME: think about returning a DTO to the frontend here
	@Override
	public ListOfPublishers getListOfPublishers(SubscriberId subscriberId) {
		ListOfPublishers listOfPublishers = lopDao.getByNaturalId(subscriberId);
		return listOfPublishers;
	}


	@Override
	public void subscribeToPublisher(SubscriberId subscriberId, PublisherId publisherId, UserMetadata publisherMetadata) {
		if (lopEntryDao.existsByNaturalId(subscriberId, publisherId))
			throw new IllegalArgumentException("cannot subscribe to publisher (" + publisherId + ") again!");

		logger.trace("in informationConsumer {}: subscribing to publisher {}", subscriberId, publisherId);

		LopEntry entry = new LopEntry(publisherId);
		entry.setPublisherMetadata(publisherMetadata);
		entry.setSubscriptionState(SubscriberSideSubscriptionState.requested);
		lopEntryDao.addNewEntity(subscriberId, entry);

		UserMetadata subscriberMetadata = userMetadataDao.getByNaturalId(subscriberId.getUserId());

		subscriberCommandSender.subscribe(subscriberId, publisherId, subscriberMetadata);
	}


	@Override
	public void unsubscribe(SubscriberId subscriberId, PublisherId publisherId) {
		if (!lopEntryDao.existsByNaturalId(subscriberId, publisherId))
			throw new IllegalArgumentException("cannot unsubscribe from publisher (" + publisherId
					+ "), that has not been added yet!");

		logger.trace("in informationConsumer {}: unsubscribing from publisher {}", subscriberId, publisherId);

		lopEntryDao.deleteByNaturalId(subscriberId, publisherId);

		subscriberCommandSender.unsubscribe(subscriberId, publisherId);
	}

}

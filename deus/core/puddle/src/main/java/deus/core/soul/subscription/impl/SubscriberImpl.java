package deus.core.soul.subscription.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.common.user.UserMetadataDao;
import deus.core.access.storage.api.sub.LopDoRep;
import deus.core.access.storage.api.sub.LopEntryDoRep;
import deus.core.access.transfer.core.sending.command.SubscriberCommandSender;
import deus.core.soul.difgoverning.DifGovernor;
import deus.core.soul.subscription.Subscriber;
import deus.model.common.dossier.Patch;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.id.UserId;
import deus.model.subscription.ListOfPublishers;
import deus.model.subscription.LopEntry;
import deus.model.subscription.SubscriberSideSubscriptionState;

@Component
@Qualifier("target")
public class SubscriberImpl implements Subscriber {

	private final Logger logger = LoggerFactory.getLogger(SubscriberImpl.class);

	@Autowired
	private UserMetadataDao userMetadataDao;

	@Autowired
	private LopEntryDoRep lopEntryDoRep;

	@Autowired
	private LopDoRep lopDoRep;

	@Autowired
	private DifGovernor difGovernor;

	@Autowired
	private SubscriberCommandSender subscriberCommandSender;


	// +++ exported to PEER +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


	@Override
	public void noticeSubscriptionRequestGranted(UserId subscriberId, UserId publisherId) {
		logger.trace("in informationConsumer of {}: publisher {} acknowledged subscription", subscriberId, publisherId);

		LopEntry entry = lopEntryDoRep.getByNaturalId(publisherId, subscriberId);
		entry.setSubscriptionState(SubscriberSideSubscriptionState.established);

		lopEntryDoRep.updateEntity(subscriberId, entry);
	}


	@Override
	public void noticeSubscriptionRequestDenied(UserId subscriberId, UserId publisherId) {
		logger.trace("in informationConsumer of {}: publisher {} denied subscription", subscriberId, publisherId);

		lopEntryDoRep.deleteByNaturalId(publisherId, subscriberId);
	}


	@Override
	public void update(UserId subscriberId, UserId publisherId, Patch patch) {
		if (!patch.getCpId().equals(publisherId))
			throw new IllegalArgumentException("ID of publisher does not match CP ID in passed digital card");

		logger.trace("in informationConsumer {}: updating the DIF for publisher {}", subscriberId, publisherId);

		if (!lopEntryDoRep.containsEntity(publisherId, subscriberId))
			// FIXME: how to handle this Exception??
			;

		difGovernor.applyPatch(subscriberId, publisherId, patch);
	}
	
	
	@Override
	public void addPublisher(UserId subscriberId, UserId publisherId, UserMetadata publisherMetadata) {
		logger.trace("in informationConsumer of {}: publisher {} added", subscriberId, publisherId);

		LopEntry entry = new LopEntry(publisherId);
		entry.setPublisherMetadata(publisherMetadata);
		entry.setSubscriptionState(SubscriberSideSubscriptionState.established);

		lopEntryDoRep.addNewEntity(subscriberId, entry);
	}


	@Override
	public void deletePublisher(UserId subscriberId, UserId publisherId) {
		logger.trace("in informationConsumer of {}: publisher {} deleted", subscriberId, publisherId);

		lopEntryDoRep.deleteByNaturalId(publisherId, subscriberId);
	}

	

	// +++ exported to CLIENT +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


	// FIXME: think about returning a DTO to the frontend here
	@Override
	public ListOfPublishers getListOfPublishers(UserId subscriberId) {
		ListOfPublishers listOfPublishers = lopDoRep.getByNaturalId(subscriberId);
		return listOfPublishers;
	}


	@Override
	public void subscribeToPublisher(UserId subscriberId, UserId publisherId, UserMetadata publisherMetadata) {
		if (lopEntryDoRep.containsEntity(publisherId, subscriberId))
			throw new IllegalArgumentException("cannot subscribe to publisher (" + publisherId + ") again!");

		logger.trace("in informationConsumer {}: subscribing to publisher {}", subscriberId, publisherId);

		LopEntry entry = new LopEntry(publisherId);
		entry.setPublisherMetadata(publisherMetadata);
		entry.setSubscriptionState(SubscriberSideSubscriptionState.requested);
		lopEntryDoRep.addNewEntity(subscriberId, entry);

		UserMetadata subscriberMetadata = userMetadataDao.getByNaturalId(subscriberId);

		subscriberCommandSender.subscribe(subscriberId, publisherId, subscriberMetadata);
	}


	@Override
	public void unsubscribe(UserId subscriberId, UserId publisherId) {
		if (!lopEntryDoRep.containsEntity(publisherId, subscriberId))
			throw new IllegalArgumentException("cannot unsubscribe from publisher (" + publisherId
					+ "), that has not been added yet!");

		logger.trace("in informationConsumer {}: unsubscribing from publisher {}", subscriberId, publisherId);

		lopEntryDoRep.deleteByNaturalId(publisherId, subscriberId);

		subscriberCommandSender.unsubscribe(subscriberId, publisherId);
	}

}

package deus.core.soul.subscription.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.storage.api.sub.LopDoRep;
import deus.core.access.storage.api.sub.LopEntryDoRep;
import deus.core.access.storage.api.user.UserMetadataDoRep;
import deus.core.access.transport.core.sending.command.SubscriberCommandSender;
import deus.core.soul.difgoverning.DifGovernor;
import deus.core.soul.subscription.Subscriber;
import deus.model.dossier.DigitalCard;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.LopEntry;
import deus.model.sub.SubscriberSideSubscriptionState;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Component
@Qualifier("target")
public class SubscriberImpl implements Subscriber {

	private final Logger logger = LoggerFactory.getLogger(SubscriberImpl.class);

	@Autowired
	private UserMetadataDoRep userMetadataDoRep;

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
		logger.trace("in subscriber of {}: publisher {} acknowledged subscription", subscriberId, publisherId);

		LopEntry entry = lopEntryDoRep.getByNaturalId(publisherId, subscriberId);
		entry.setSubscriptionState(SubscriberSideSubscriptionState.established);

		lopEntryDoRep.updateEntity(subscriberId, entry);
	}


	@Override
	public void noticeSubscriptionRequestDenied(UserId subscriberId, UserId publisherId) {
		logger.trace("in subscriber of {}: publisher {} denied subscription", subscriberId, publisherId);

		lopEntryDoRep.deleteByNaturalId(publisherId, subscriberId);
	}


	@Override
	public void update(UserId subscriberId, UserId publisherId, DigitalCard digitalCard) {
		if (!digitalCard.getDigitalCardId().getCpId().equals(publisherId))
			throw new IllegalArgumentException("ID of publisher does not match CP ID in passed digital card");

		logger.trace("in subscriber {}: updating the DIF for publisher {}", subscriberId, publisherId);

		if (!lopEntryDoRep.containsEntity(publisherId, subscriberId))
			// FIXME: how to handle this??
			;

		difGovernor.assimilatePublishedDigitalCard(subscriberId, publisherId, digitalCard);
	}
	
	
	@Override
	public void addPublisher(UserId subscriberId, UserId publisherId, UserMetadata publisherMetadata) {
		logger.trace("in subscriber of {}: publisher {} added", subscriberId, publisherId);

		LopEntry entry = new LopEntry(publisherId);
		entry.setPublisherMetadata(publisherMetadata);
		entry.setSubscriptionState(SubscriberSideSubscriptionState.established);

		lopEntryDoRep.addNewEntity(subscriberId, entry);
	}


	@Override
	public void deletePublisher(UserId subscriberId, UserId publisherId) {
		logger.trace("in subscriber of {}: publisher {} deleted", subscriberId, publisherId);

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

		logger.trace("in subscriber {}: subscribing to publisher {}", subscriberId, publisherId);

		LopEntry entry = new LopEntry(publisherId);
		entry.setPublisherMetadata(publisherMetadata);
		entry.setSubscriptionState(SubscriberSideSubscriptionState.requested);
		lopEntryDoRep.addNewEntity(subscriberId, entry);

		UserMetadata subscriberMetadata = userMetadataDoRep.getByNaturalId(subscriberId);

		subscriberCommandSender.subscribe(subscriberId, publisherId, subscriberMetadata);
	}


	@Override
	public void unsubscribe(UserId subscriberId, UserId publisherId) {
		if (!lopEntryDoRep.containsEntity(publisherId, subscriberId))
			throw new IllegalArgumentException("cannot unsubscribe from publisher (" + publisherId
					+ "), that has not been added yet!");

		logger.trace("in subscriber {}: unsubscribing from publisher {}", subscriberId, publisherId);

		lopEntryDoRep.deleteByNaturalId(publisherId, subscriberId);

		subscriberCommandSender.unsubscribe(subscriberId, publisherId);
	}

}

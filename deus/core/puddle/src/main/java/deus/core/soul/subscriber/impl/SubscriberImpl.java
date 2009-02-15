package deus.core.soul.subscriber.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import deus.core.access.transport.core.sending.command.SubscriberCommandSender;
import deus.core.soul.common.InformationFileUpdateStrategy;
import deus.core.soul.subscriber.Subscriber;
import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.dossier.DigitalCard;
import deus.model.dossier.generic.InformationFile;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.LopEntry;
import deus.model.sub.SubscriptionState;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Configurable
public class SubscriberImpl implements Subscriber {

	private final Logger logger = LoggerFactory.getLogger(SubscriberImpl.class);


	private final UserId subscriberId;
	private final UserMetadata subscriberMetadata;

	protected final ListOfPublishers listOfPublishers;

	private final DistributedInformationFolder distributedInformationFolder;

	@Resource(name="foreignInformationFileUpdateStrategy")
	private InformationFileUpdateStrategy foreignInformationFileUpdateStrategy;

	@Autowired
	private SubscriberCommandSender subscriberCommandSender;


	public SubscriberImpl(ListOfPublishers listOfPublishers, UserId subscriberId, UserMetadata subscriberMetadata,
			DistributedInformationFolder distributedInformationFolder) {
		this.listOfPublishers = listOfPublishers;

		this.subscriberId = subscriberId;
		this.subscriberMetadata = subscriberMetadata;

		this.distributedInformationFolder = distributedInformationFolder;
	}


	@Override
	public UserId getSubscriberId() {
		return subscriberId;
	}


	@Override
	public DistributedInformationFolder getDistributedInformationFolder() {
		return distributedInformationFolder;
	}


	public ListOfPublishers getListOfPublishers() {
		return listOfPublishers;
	}


	@Override
	public void update(UserId publisherId, DigitalCard digitalCard) {
		if(!digitalCard.getCpId().equals(subscriberId))
			// FIXME: how to handle this??
			;
		logger.trace("in subscriber {}: updating the DIF for publisher {}", getSubscriberId(), publisherId);
		
		if (!listOfPublishers.containsKey(publisherId))
			// FIXME: how to handle this??
			;

		InformationFile fif = distributedInformationFolder.getForeignInformationFile(publisherId);
		foreignInformationFileUpdateStrategy.update(fif, digitalCard);
	}


	@Override
	public void acknowledgeSubscription(UserId publisherId) {
		logger.trace("in subscriber of {}: publisher {} acknowledged subscription", getSubscriberId(), publisherId);

		listOfPublishers.changeState(publisherId, SubscriptionState.granted);
	}


	@Override
	public void denySubscription(UserId publisherId) {
		logger.trace("in subscriber of {}: publisher {} denied subscription", getSubscriberId(), publisherId);

		listOfPublishers.remove(publisherId);
	}


	@Override
	public void subscribe(UserId publisherId, UserMetadata publisherMetadata) {
		if (listOfPublishers.containsKey(publisherId))
			throw new IllegalArgumentException("cannot subscribe to publisher (" + publisherId + ") again!");

		logger.trace("in subscriber {}: subscribing to publisher {}", getSubscriberId(), publisherId);


		LopEntry entry = new LopEntry();
		entry.setPublisherMetadata(publisherMetadata);
		entry.setSubscriptionState(SubscriptionState.requested);
		listOfPublishers.put(publisherId, entry);

		subscriberCommandSender.subscribe(subscriberId, publisherId, subscriberMetadata);
	}


	@Override
	public void unsubscribe(UserId publisherId) {
		if (!listOfPublishers.containsKey(publisherId))
			throw new IllegalArgumentException("cannot unsubscribe from publisher (" + publisherId
					+ "), that has not been added yet!");

		logger.trace("in subscriber {}: unsubscribing from publisher {}", getSubscriberId(), publisherId);

		listOfPublishers.remove(publisherId);

		subscriberCommandSender.unsubscribe(subscriberId, publisherId);
	}

}

package deus.core.soul.subscriber.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.storage.sub.api.SubDao;
import deus.core.access.storage.user.api.UserDao;
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

@Component
public class SubscriberImpl implements Subscriber {

	private final Logger logger = LoggerFactory.getLogger(SubscriberImpl.class);

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SubDao subDao;

	@Resource(name="foreignInformationFileUpdateStrategy")
	private InformationFileUpdateStrategy foreignInformationFileUpdateStrategy;

	@Autowired
	private SubscriberCommandSender subscriberCommandSender;


	// FIXME: think about returning a DTO to the frontend here
	@Override
	public DistributedInformationFolder getDistributedInformationFolder(UserId subscriberId) {
		DistributedInformationFolder distributedInformationFolder = subDao.getDistributedInformationFolder(subscriberId);
		return distributedInformationFolder;
	}

	// FIXME: think about returning a DTO to the frontend here
	@Override
	public ListOfPublishers getListOfPublishers(UserId subscriberId) {
		ListOfPublishers listOfPublishers = subDao.getListOfPublishers(subscriberId);
		return listOfPublishers;
	}


	@Override
	public void update(UserId subscriberId, UserId publisherId, DigitalCard digitalCard) {
		if(!digitalCard.getCpId().equals(publisherId))
			throw new IllegalArgumentException("ID of publisher does not match CP ID in passed digital card");
		
		logger.trace("in subscriber {}: updating the DIF for publisher {}", subscriberId, publisherId);
		
		ListOfPublishers listOfPublishers = subDao.getListOfPublishers(subscriberId);

		if (!listOfPublishers.containsKey(publisherId))
			// FIXME: how to handle this??
			;
		DistributedInformationFolder distributedInformationFolder = subDao.getDistributedInformationFolder(subscriberId);
		
		InformationFile fif = distributedInformationFolder.getForeignInformationFile(publisherId);
		foreignInformationFileUpdateStrategy.update(fif, digitalCard);
		
		// FIXME: store FIF by using dao.store():
	}


	@Override
	public void acknowledgeSubscription(UserId subscriberId, UserId publisherId) {
		logger.trace("in subscriber of {}: publisher {} acknowledged subscription", subscriberId, publisherId);

		ListOfPublishers listOfPublishers = subDao.getListOfPublishers(subscriberId);

		listOfPublishers.changeState(publisherId, SubscriptionState.granted);
		
		// FIXME: store LoP by using dao.store()
	}


	@Override
	public void denySubscription(UserId subscriberId, UserId publisherId) {
		logger.trace("in subscriber of {}: publisher {} denied subscription", subscriberId, publisherId);

		ListOfPublishers listOfPublishers = subDao.getListOfPublishers(subscriberId);
		
		listOfPublishers.remove(publisherId);
		
		// FIXME: store LoP by using dao.store()
	}


	@Override
	public void subscribe(UserId subscriberId, UserId publisherId, UserMetadata publisherMetadata) {
		ListOfPublishers listOfPublishers = subDao.getListOfPublishers(subscriberId);

		if (listOfPublishers.containsKey(publisherId))
			throw new IllegalArgumentException("cannot subscribe to publisher (" + publisherId + ") again!");

		logger.trace("in subscriber {}: subscribing to publisher {}", subscriberId, publisherId);


		LopEntry entry = new LopEntry();
		entry.setPublisherMetadata(publisherMetadata);
		entry.setSubscriptionState(SubscriptionState.requested);
		listOfPublishers.put(publisherId, entry);

		// FIXME: store LoP by using dao.store()
		
		
		UserMetadata subscriberMetadata = userDao.getUserMetadata(subscriberId);
		
		subscriberCommandSender.subscribe(subscriberId, publisherId, subscriberMetadata);
	}


	@Override
	public void unsubscribe(UserId subscriberId, UserId publisherId) {
		ListOfPublishers listOfPublishers = subDao.getListOfPublishers(subscriberId);

		if (!listOfPublishers.containsKey(publisherId))
			throw new IllegalArgumentException("cannot unsubscribe from publisher (" + publisherId
					+ "), that has not been added yet!");

		logger.trace("in subscriber {}: unsubscribing from publisher {}", subscriberId, publisherId);

		listOfPublishers.remove(publisherId);
		
		// FIXME: store LoP by using dao.store()

		subscriberCommandSender.unsubscribe(subscriberId, publisherId);
	}

}

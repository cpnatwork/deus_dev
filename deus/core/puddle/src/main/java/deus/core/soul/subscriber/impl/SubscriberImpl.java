package deus.core.soul.subscriber.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import deus.core.soul.subscriber.Subscriber;
import deus.core.transport.sending.command.SubscriberCommandSender;
import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.LopEntry;
import deus.model.sub.SubscriptionState;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

// TODO: add DIF
@Configurable
public class SubscriberImpl implements Subscriber {

	private final UserId subscriberId;
	private final UserMetadata subscriberMetadata;

	protected final ListOfPublishers listOfPublishers;

	@Autowired
	private SubscriberCommandSender subscriberCommandSender;


	public SubscriberImpl(ListOfPublishers listOfPublishers, UserId subscriberId, UserMetadata subscriberMetadata) {
		this.listOfPublishers = listOfPublishers;

		this.subscriberId = subscriberId;
		this.subscriberMetadata = subscriberMetadata;
	}


	@Override
	public UserId getSubscriberId() {
		return subscriberId;
	}

	
	@Override
	public DistributedInformationFolder getDistributedInformationFolder() {
		// TODO Auto-generated method stub
		return null;
	}


	public ListOfPublishers getListOfPublishers() {
		return listOfPublishers;
	}


	@Override
	public void update(UserMetadata publisherMetadata, ForeignInformationFile fif) {
		if (!listOfPublishers.containsKey(publisherMetadata))
			// FIXME: how to handle this??
			;
		// FIXME: how to do object change (append, update, ...)
	}


	@Override
	public void acknowledgeSubscription(UserId publisherId) {
		listOfPublishers.changeState(publisherId, SubscriptionState.granted);
	}


	@Override
	public void denySubscription(UserId publisherId) {
		listOfPublishers.remove(publisherId);
	}


	@Override
	public void subscribe(UserId publisherId, UserMetadata publisherMetadata) {
		if (listOfPublishers.containsKey(publisherId))
			throw new IllegalArgumentException("cannot subscribe to publisher (" + publisherId
					+ ") again!");

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

		listOfPublishers.remove(publisherId);

		subscriberCommandSender.unsubscribe(subscriberId, publisherId);
	}

}

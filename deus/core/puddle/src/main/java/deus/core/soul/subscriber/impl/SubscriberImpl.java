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

	private final UserMetadata subscriberMetadata;
	protected final ListOfPublishers listOfPublishers;

	@Autowired
	private SubscriberCommandSender subscriberCommandSender;


	public SubscriberImpl(ListOfPublishers listOfPublishers, UserMetadata subscriberMetadata) {
		this.listOfPublishers = listOfPublishers;
		this.subscriberMetadata = subscriberMetadata;
	}


	@Override
	public UserMetadata getSubscriberMetadata() {
		return subscriberMetadata;
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
	public void subscribe(UserMetadata publisherMetadata) {
		if (listOfPublishers.containsKey(publisherMetadata.getUserId()))
			throw new IllegalArgumentException("cannot subscribe to publisher (" + publisherMetadata.getUserId() + ") again!");

		LopEntry entry = new LopEntry();
		entry.setPublisherMetadata(publisherMetadata);
		entry.setSubscriptionState(SubscriptionState.requested);
		listOfPublishers.put(publisherMetadata.getUserId(), entry);

		subscriberCommandSender.subscribe(subscriberMetadata.getUserId(), publisherMetadata.getUserId(), subscriberMetadata);
	}


	@Override
	public void unsubscribe(UserMetadata publisherMetadata) {
		if (!listOfPublishers.containsKey(publisherMetadata.getUserId()))
			throw new IllegalArgumentException("cannot unsubscribe from publisher (" + publisherMetadata.getUserId()
					+ "), that has not been added yet!");

		listOfPublishers.remove(publisherMetadata.getUserId());

		subscriberCommandSender.unsubscribe(subscriberMetadata.getUserId(), publisherMetadata.getUserId());
	}

}

package deus.core.soul.publication.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers;
import deus.core.soul.publication.Publisher;
import deus.core.soul.publication.PublisherExportedToClient;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.publication.ListOfSubscribers;

/**
 * Delegates all methods of <code>PublisherExportedToPeers</code> to a delegate of type
 * <code>PublisherExportedToPeers</code>, the rest of the methods of <code>Publisher</code> are delegated to the second
 * delegate, which is of type <code>Publisher</code>.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
@Component("publisher")
public class ProxiedPublisherAdapter implements Publisher {

	@Autowired
	private PublisherExportedToClient publisherExportedToClient;

	@Autowired
	@Qualifier("proxy")
	private PublisherExportedToPeers publisherExportedToPeers;


	// +++ exported to PEER +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	@Override
	public void addSubscriber(PublisherId publisherId, SubscriberId subscriberId, UserMetadata subscriberMetadata) {
		publisherExportedToPeers.addSubscriber(publisherId, subscriberId, subscriberMetadata);
	}


	@Override
	public void deleteSubscriber(PublisherId publisherId, SubscriberId subscriberId) {
		publisherExportedToPeers.deleteSubscriber(publisherId, subscriberId);
	}


	@Override
	public void subscriptionAbstained(PublisherId publisherId, SubscriberId subscriberId) {
		publisherExportedToPeers.subscriptionAbstained(publisherId, subscriberId);
	}


	@Override
	public void subscriptionConfirmed(PublisherId publisherId, SubscriberId subscriberId) {
		publisherExportedToPeers.subscriptionConfirmed(publisherId, subscriberId);
	}


	// +++ exported to CLIENT +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


	@Override
	public ListOfSubscribers getListOfSubscribers(PublisherId publisherId) {
		return publisherExportedToClient.getListOfSubscribers(publisherId);
	}


	@Override
	public void notifySubscriber(PublisherId publisherId, SubscriberId subscriberId, DigitalCard digitalCard) {
		publisherExportedToClient.notifySubscriber(publisherId, subscriberId, digitalCard);
	}


	@Override
	public void notifySubscribers(PublisherId publisherId, DigitalCard digitalCard) {
		publisherExportedToClient.notifySubscribers(publisherId, digitalCard);
	}


	@Override
	public void cancelSubscription(PublisherId publisherId, SubscriberId subscriberId) {
		publisherExportedToClient.cancelSubscription(publisherId, subscriberId);
	}


	@Override
	public void inviteSubscriber(PublisherId publisherId, SubscriberId subscriberId, UserMetadata subscriberMetadata) {
		publisherExportedToClient.inviteSubscriber(publisherId, subscriberId, subscriberMetadata);
	}

}

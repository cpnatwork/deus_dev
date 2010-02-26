package deus.core.soul.subscription.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers;
import deus.core.soul.subscription.Subscriber;
import deus.core.soul.subscription.SubscriberExportedToClient;
import deus.model.common.dossier.Patch;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.subscription.ListOfPublishers;

/**
 * Delegates all methods of <code>SubscriberExportedToPeers</code> to a delegate of type
 * <code>SubscriberExportedToPeers</code>, the rest of the methods of <code>Subscriber</code> are delegated to the second
 * delegate, which is of type <code>Subscriber</code>.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
@Component("subscriber")
public class ProxiedSubscriberAdapter implements Subscriber {

	@Autowired
	private SubscriberExportedToClient subscriberExportedToClient;


	@Autowired
	@Qualifier("proxy")
	private SubscriberExportedToPeers subscriberExportedToPeers;


	// +++ METHODS SUBSCRIBER EXPORTED TO PEER ++++++++++++++++++++++++++++++++++++++++++++++++++++++

	@Override
	public void noticeSubscriptionRequestGranted(SubscriberId subscriberId, PublisherId publisherId) {
		subscriberExportedToPeers.noticeSubscriptionRequestGranted(subscriberId, publisherId);
	}


	@Override
	public void noticeSubscriptionRequestDenied(SubscriberId subscriberId, PublisherId publisherId) {
		subscriberExportedToPeers.noticeSubscriptionRequestDenied(subscriberId, publisherId);
	}


	@Override
	public void update(SubscriberId subscriberId, PublisherId publisherId, Patch patch) {
		subscriberExportedToPeers.update(subscriberId, publisherId, patch);
	}


	@Override
	public void addPublisher(SubscriberId subscriberId, PublisherId publisherId, UserMetadata publisherMetadata) {
		subscriberExportedToPeers.addPublisher(subscriberId, publisherId, publisherMetadata);
	}


	@Override
	public void deletePublisher(SubscriberId subscriberId, PublisherId publisherId) {
		subscriberExportedToPeers.deletePublisher(subscriberId, publisherId);
	}


	// +++ METHODS OF SUBSCRIBER EXPORTED TO CLIENT +++++++++++++++++++++++++++++++++++++++++++++++++


	@Override
	public void subscribeToPublisher(SubscriberId subscriberId, PublisherId publisherId, UserMetadata publisherMetadata) {
		subscriberExportedToClient.subscribeToPublisher(subscriberId, publisherId, publisherMetadata);
	}


	@Override
	public void unsubscribe(SubscriberId subscriberId, PublisherId publisherId) {
		subscriberExportedToClient.unsubscribe(subscriberId, publisherId);
	}


	@Override
	public ListOfPublishers getListOfPublishers(SubscriberId subscriberId) {
		return subscriberExportedToClient.getListOfPublishers(subscriberId);
	}


}

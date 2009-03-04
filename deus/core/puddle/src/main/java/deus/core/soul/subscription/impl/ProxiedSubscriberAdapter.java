package deus.core.soul.subscription.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.receiving.soulcallback.SubscriberExportedToPeer;
import deus.core.soul.subscription.Subscriber;
import deus.core.soul.subscription.SubscriberExportedToClient;
import deus.model.dossier.DigitalCard;
import deus.model.dossier.DigitalCardId;
import deus.model.sub.ListOfPublishers;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

/**
 * Delegates all methods of <code>SubscriberExportedToPeer</code> to a delegate of type
 * <code>SubscriberExportedToPeer</code>, the rest of the methods of <code>Subscriber</code> are delegated to the second
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
	private SubscriberExportedToPeer subscriberExportedToPeer;


	// +++ METHODS SUBSCRIBER EXPORTED TO PEER ++++++++++++++++++++++++++++++++++++++++++++++++++++++

	@Override
	public void noticeSubscriptionRequestGranted(UserId subscriberId, UserId publisherId) {
		subscriberExportedToPeer.noticeSubscriptionRequestGranted(subscriberId, publisherId);
	}


	@Override
	public void noticeSubscriptionRequestDenied(UserId subscriberId, UserId publisherId) {
		subscriberExportedToPeer.noticeSubscriptionRequestDenied(subscriberId, publisherId);
	}


	@Override
	public void update(UserId subscriberId, UserId publisherId, DigitalCard digitalCard) {
		subscriberExportedToPeer.update(subscriberId, publisherId, digitalCard);
	}


	@Override
	public void addPublisher(UserId subscriberId, UserId publisherId, UserMetadata publisherMetadata) {
		subscriberExportedToPeer.addPublisher(subscriberId, publisherId, publisherMetadata);
	}


	@Override
	public void deletePublisher(UserId subscriberId, UserId publisherId) {
		subscriberExportedToPeer.deletePublisher(subscriberId, publisherId);
	}


	// +++ METHODS OF SUBSCRIBER EXPORTED TO CLIENT +++++++++++++++++++++++++++++++++++++++++++++++++


	@Override
	public void subscribeToPublisher(UserId subscriberId, UserId publisherId, UserMetadata publisherMetadata) {
		subscriberExportedToClient.subscribeToPublisher(subscriberId, publisherId, publisherMetadata);
	}


	@Override
	public void unsubscribe(UserId subscriberId, UserId publisherId) {
		subscriberExportedToClient.unsubscribe(subscriberId, publisherId);
	}


	@Override
	public ListOfPublishers getListOfPublishers(UserId subscriberId) {
		return subscriberExportedToClient.getListOfPublishers(subscriberId);
	}


	@Override
	public List<UserId> getPublishersInDif(UserId subscriberId) {
		return subscriberExportedToClient.getPublishersInDif(subscriberId);
	}


	@Override
	public List<DigitalCardId> getDigitalCardIdsInFif(UserId subscriberId, UserId publisherId) {
		return subscriberExportedToClient.getDigitalCardIdsInFif(subscriberId, publisherId);
	}


	@Override
	public DigitalCard getDigitalCardInFif(UserId subscriberId, DigitalCardId digitalCardId) {
		return subscriberExportedToClient.getDigitalCardInFif(subscriberId, digitalCardId);
	}


}

package deus.core.soul.subscriber.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.receiving.soulcallback.SubscriberExportedToPeer;
import deus.core.soul.subscriber.Subscriber;
import deus.core.soul.subscriber.SubscriberExportedToClient;
import deus.model.dossier.DigitalCard;
import deus.model.sub.DistributedInformationFolder;
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


	// +++ METHODS OF REMOTE CALLED SUBSCRIBER ++++++++++++++++++++++++++++++++++++++++++++++++++++++

	@Override
	public void acknowledgeSubscription(UserId subscriberId, UserId publisherId) {
		subscriberExportedToPeer.acknowledgeSubscription(subscriberId, publisherId);
	}


	@Override
	public void denySubscription(UserId subscriberId, UserId publisherId) {
		subscriberExportedToPeer.denySubscription(subscriberId, publisherId);
	}


	@Override
	public void update(UserId subscriberId, UserId publisherId, DigitalCard digitalCard) {
		subscriberExportedToPeer.update(subscriberId, publisherId, digitalCard);
	}


	// +++ METHODS OF SUBSCRIBER ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


	@Override
	public DistributedInformationFolder getDistributedInformationFolder(UserId subscriberId) {
		return subscriberExportedToClient.getDistributedInformationFolder(subscriberId);
	}


	@Override
	public void subscribe(UserId subscriberId, UserId publisherId, UserMetadata publisherMetadata) {
		subscriberExportedToClient.subscribe(subscriberId, publisherId, publisherMetadata);
	}


	@Override
	public void unsubscribe(UserId subscriberId, UserId publisherId) {
		subscriberExportedToClient.unsubscribe(subscriberId, publisherId);
	}


	@Override
	public ListOfPublishers getListOfPublishers(UserId subscriberId) {
		return subscriberExportedToClient.getListOfPublishers(subscriberId);
	}


}

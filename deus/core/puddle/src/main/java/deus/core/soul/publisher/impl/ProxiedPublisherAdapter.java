package deus.core.soul.publisher.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.receiving.soulcallback.PublisherExportedToPeer;
import deus.core.soul.publisher.Publisher;
import deus.core.soul.publisher.PublisherExportedToClient;
import deus.model.dossier.DigitalCard;
import deus.model.pub.ListOfSubscribers;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

/**
 * Delegates all methods of <code>PublisherExportedToPeer</code> to a delegate of type
 * <code>PublisherExportedToPeer</code>, the rest of the methods of <code>Publisher</code> are delegated to the second
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
	private PublisherExportedToPeer publisherExportedToPeer;


	// +++ METHODS OF PUBLISHER EXPORTED TO PEER ++++++++++++++++++++++++++++++++++++++++++++++++++++++

	@Override
	public void addSubscriber(UserId publisherId, UserId subscriberId, UserMetadata subscriberMetadata) {
		publisherExportedToPeer.addSubscriber(publisherId, subscriberId, subscriberMetadata);
	}


	@Override
	public void deleteSubscriber(UserId publisherId, UserId subscriberId) {
		publisherExportedToPeer.deleteSubscriber(publisherId, subscriberId);
	}


	// +++ METHODS OF PUBLISHER EXPORTED TO CLIENT ++++++++++++++++++++++++++++++++++++++++++++++++++++


	@Override
	public ListOfSubscribers getListOfSubscribers(UserId publisherId) {
		return publisherExportedToClient.getListOfSubscribers(publisherId);
	}


	@Override
	public void notifySubscriber(UserId publisherId, UserId subscriberId, DigitalCard digitalCard) {
		publisherExportedToClient.notifySubscriber(publisherId, subscriberId, digitalCard);
	}


	@Override
	public void notifySubscribers(UserId publisherId, DigitalCard digitalCard) {
		publisherExportedToClient.notifySubscribers(publisherId, digitalCard);
	}


}

package deus.core.soul.publisher.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.soul.publisher.Publisher;
import deus.core.soul.publisher.PublisherExportedToClient;
import deus.core.soul.publisher.PublisherExportedToPeer;
import deus.model.dossier.DigitalCard;
import deus.model.pub.ListOfSubscribers;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

/**
 * Delegates all methods of <code>PublisherExportedToPeer</code> to a delegate of type <code>PublisherExportedToPeer</code>,
 * the rest of the methods of <code>Publisher</code> are delegated to the second delegate, which is of type
 * <code>Publisher</code>.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
@Component
public class RemoteCalledPublisherToPublisherAdapter implements Publisher {

	@Autowired
	private PublisherExportedToClient publisherExportedToClient;
	@Autowired
	private PublisherExportedToPeer publisherExportedToPeer;



//	+++ METHODS OF REMOTE CALLED PUBLISHER ++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@Override
	public void addSubscriber(UserId publisherId, UserId subscriberId, UserMetadata subscriberMetadata) {
		publisherExportedToPeer.addSubscriber(publisherId, subscriberId, subscriberMetadata);
	}


	@Override
	public void deleteSubscriber(UserId publisherId, UserId subscriberId) {
		publisherExportedToPeer.deleteSubscriber(publisherId, subscriberId);
	}

//	+++ METHODS OF PUBLISHER ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@Override
	public int countSubscribers(UserId publisherId) {
		return publisherExportedToClient.countSubscribers(publisherId);
	}


	@Override
	public void deleteSubscribers(UserId publisherId) {
		publisherExportedToClient.deleteSubscribers(publisherId);
	}


	@Override
	public ListOfSubscribers getListOfSubscribers(UserId publisherId) {
		return publisherExportedToClient.getListOfSubscribers(publisherId);
	}


	@Override
	public void notifySubscribers(UserId publisherId, DigitalCard digitalCard) {
		publisherExportedToClient.notifySubscribers(publisherId, digitalCard);
	}

}

package deus.core.soul.subscriber.impl;

import deus.core.soul.subscriber.RemoteCalledSubscriber;
import deus.core.soul.subscriber.Subscriber;
import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.dossier.DigitalCard;
import deus.model.sub.ListOfPublishers;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

/**
 * Delegates all methods of <code>RemoteCalledSubscriber</code> to a delegate of type
 * <code>RemoteCalledSubscriber</code>, the rest of the methods of <code>Subscriber</code> are delegated to the second
 * delegate, which is of type <code>Subscriber</code>.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public class RemoteCalledSubscriberToSubscriberAdapter implements Subscriber {

	private final RemoteCalledSubscriber remoteCalledSubscriber;
	private final Subscriber subscriber;


	public RemoteCalledSubscriberToSubscriberAdapter(RemoteCalledSubscriber remoteCalledSubscriber,
			Subscriber subscriber) {
		super();
		this.remoteCalledSubscriber = remoteCalledSubscriber;
		this.subscriber = subscriber;
	}


	// +++ METHODS OF REMOTE CALLED SUBSCRIBER ++++++++++++++++++++++++++++++++++++++++++++++++++++++

	@Override
	public void acknowledgeSubscription(UserId publisherId) {
		remoteCalledSubscriber.acknowledgeSubscription(publisherId);
	}


	@Override
	public void denySubscription(UserId publisherId) {
		remoteCalledSubscriber.denySubscription(publisherId);
	}


	@Override
	public void update(UserId publisherId, DigitalCard digitalCard) {
		remoteCalledSubscriber.update(publisherId, digitalCard);
	}


	// +++ METHODS OF SUBSCRIBER ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


	@Override
	public DistributedInformationFolder getDistributedInformationFolder() {
		return subscriber.getDistributedInformationFolder();
	}



	@Override
	public UserId getSubscriberId() {
		return subscriber.getSubscriberId();
	}


	@Override
	public void subscribe(UserId publisherId, UserMetadata publisherMetadata) {
		subscriber.subscribe(publisherId, publisherMetadata);
	}


	@Override
	public void unsubscribe(UserId publisherId) {
		subscriber.unsubscribe(publisherId);
	}


	@Override
	public ListOfPublishers getListOfPublishers() {
		return subscriber.getListOfPublishers();
	}


}

package deus.core.subscriber.impl;

import deus.core.subscriber.RemoteCalledSubscriber;
import deus.core.subscriber.Subscriber;
import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.SubscriptionState;
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
	public void acknowledgeSubscription(UserMetadata publisherMetadata) {
		remoteCalledSubscriber.acknowledgeSubscription(publisherMetadata);
	}


	@Override
	public void denySubscription(UserMetadata publisherMetadata) {
		remoteCalledSubscriber.denySubscription(publisherMetadata);
	}


	@Override
	public void update(UserMetadata publisherMetadata, ForeignInformationFile fif) {
		remoteCalledSubscriber.update(publisherMetadata, fif);
	}


	// +++ METHODS OF SUBSCRIBER ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	@Override
	public void addPublisher(UserMetadata publisherMetadata, SubscriptionState subscriptionState) {
		subscriber.addPublisher(publisherMetadata, subscriptionState);
	}


	@Override
	public DistributedInformationFolder getDistributedInformationFolder() {
		return subscriber.getDistributedInformationFolder();
	}


	@Override
	public UserMetadata getSubscriberMetadata() {
		return subscriber.getSubscriberMetadata();
	}


	@Override
	public void removePublisher(UserMetadata publisherMetadata) {
		subscriber.removePublisher(publisherMetadata);
	}


	@Override
	public void subscribe(UserId publisherId) {
		subscriber.subscribe(publisherId);
	}


	@Override
	public ListOfPublishers getListOfPublishers() {
		return subscriber.getListOfPublishers();
	}

}

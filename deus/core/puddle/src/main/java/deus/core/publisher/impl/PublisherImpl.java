package deus.core.publisher.impl;

import deus.core.publisher.Publisher;
import deus.core.subscriber.stub.SubscriberStub;
import deus.model.pub.ListOfSubscribers;
import deus.model.user.UserMetadata;
import deus.remoting.command.impl.AbstractPublisherRemoteCommand;
import deus.remoting.commandexecutor.RemoteCommandExecutor;

public class PublisherImpl implements Publisher {

	private final UserMetadata publisherMetadata;
	private final RemoteCommandExecutor remoteCommandExecutor;

	protected final ListOfSubscribers listOfSubscribers;


	public PublisherImpl(ListOfSubscribers listOfSubscribers, UserMetadata publisherMetadata,
			RemoteCommandExecutor remoteCommandExecutor) {
		super();
		this.listOfSubscribers = listOfSubscribers;

		this.publisherMetadata = publisherMetadata;
		this.remoteCommandExecutor = remoteCommandExecutor;
	}


	public synchronized void addObserver(UserMetadata subscriberMetadata) {
		if (subscriberMetadata == null)
			throw new NullPointerException();
		if (!listOfSubscribers.contains(subscriberMetadata)) {
			listOfSubscribers.add(subscriberMetadata);
		}
	}


	public synchronized void deleteObserver(UserMetadata subscriberMetadata) {
		listOfSubscribers.remove(subscriberMetadata);
	}


	public synchronized void deleteObservers() {
		listOfSubscribers.clear();
	}


	public synchronized int countObservers() {
		return listOfSubscribers.size();
	}


	public void notifyObservers() {
		notifyObservers(null);
	}


	public void notifyObservers(final Object change) {
		/*
		 * a temporary array buffer, used as a snapshot of the state of current Observers.
		 */
		Object[] arrLocal;

		synchronized (this) {
			/*
			 * We don't want the Observer doing callbacks into arbitrary code while holding its own Monitor. The code
			 * where we extract each Observable from the Vector and store the state of the Observer needs
			 * synchronization, but notifying observers does not (should not). The worst result of any potential
			 * race-condition here is that: 1) a newly-added Observer will miss a notification in progress 2) a recently
			 * unregistered Observer will be wrongly notified when it doesn't care
			 */
			arrLocal = listOfSubscribers.toArray();
		}

		for (int i = arrLocal.length - 1; i >= 0; i--) {
			// TODO: think about publishing using multiple threads
			UserMetadata subscriberMetadata = (UserMetadata) arrLocal[i];

			remoteCommandExecutor.execute(new AbstractPublisherRemoteCommand(subscriberMetadata.getUserId()) {

				@Override
				protected void execute(SubscriberStub subscriberStub) {
					// TODO: implement properly
					// subscriberStub.update(getPublisherMetadata(), change);
				}
				
			});
		}
	}


	@Override
	public ListOfSubscribers getListOfSubscribers() {
		return listOfSubscribers;
	}


	@Override
	public UserMetadata getPublisherMetadata() {
		return publisherMetadata;
	}

}

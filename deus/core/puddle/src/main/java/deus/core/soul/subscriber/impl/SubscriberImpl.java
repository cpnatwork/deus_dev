package deus.core.soul.subscriber.impl;

import deus.core.soul.publisher.stub.PublisherStub;
import deus.core.soul.subscriber.Subscriber;
import deus.core.transport.command.impl.AbstractSubscriberRemoteCommand;
import deus.core.transport.commandexecutor.RemoteCommandExecutor;
import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.SubscriptionState;
import deus.model.user.UserMetadata;

// TODO: add DIF
public class SubscriberImpl implements Subscriber {

	private final UserMetadata subscriberMetadata;
	protected final ListOfPublishers listOfPublishers;

	private final RemoteCommandExecutor remoteCommandExecutor;


	public SubscriberImpl(ListOfPublishers listOfPublishers, UserMetadata subscriberMetadata,
			RemoteCommandExecutor remoteCommandExecutor) {
		this.listOfPublishers = listOfPublishers;
		this.subscriberMetadata = subscriberMetadata;

		this.remoteCommandExecutor = remoteCommandExecutor;
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
	public void acknowledgeSubscription(UserMetadata publisherMetadata) {
		listOfPublishers.changeState(publisherMetadata, SubscriptionState.granted);
	}


	@Override
	public void denySubscription(UserMetadata publisherMetadata) {
		listOfPublishers.remove(publisherMetadata);
	}


	@Override
	public void subscribe(UserMetadata publisherMetadata) {
		if (listOfPublishers.containsKey(publisherMetadata))
			throw new IllegalArgumentException("cannot subscribe to publisher (" + publisherMetadata + ") again!");

		listOfPublishers.put(publisherMetadata, SubscriptionState.requested);

		remoteCommandExecutor.execute(new AbstractSubscriberRemoteCommand(publisherMetadata.getUserId()) {

			@Override
			public void execute(PublisherStub publisherStub) {
				publisherStub.addObserver(getSubscriberMetadata());
			}

		});
	}


	@Override
	public void unsubscribe(UserMetadata publisherMetadata) {
		if (!listOfPublishers.containsKey(publisherMetadata))
			throw new IllegalArgumentException("cannot unsubscribe from publisher (" + publisherMetadata
					+ "), that has not been added yet!");

		listOfPublishers.remove(publisherMetadata);

		remoteCommandExecutor.execute(new AbstractSubscriberRemoteCommand(publisherMetadata.getUserId()) {

			@Override
			public void execute(PublisherStub publisherStub) {
				publisherStub.deleteObserver(getSubscriberMetadata());
			}

		});
	}

}

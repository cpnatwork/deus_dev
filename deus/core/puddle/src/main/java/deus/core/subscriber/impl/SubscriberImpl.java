package deus.core.subscriber.impl;

import deus.core.publisher.stub.PublisherStub;
import deus.core.subscriber.Subscriber;
import deus.model.depository.generic.DistributedInformationFolder;
import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.sub.ListOfPublishers;
import deus.model.sub.SubscriptionState;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;
import deus.remoting.command.impl.AbstractSubscriberRemoteCommand;
import deus.remoting.commandexecutor.RemoteCommandExecutor;

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


	@Override
	public void addPublisher(UserMetadata publisherMetadata, SubscriptionState subscriptionState) {
		listOfPublishers.add(publisherMetadata, subscriptionState);
	}


	@Override
	public void removePublisher(UserMetadata publisherMetadata) {
		listOfPublishers.remove(publisherMetadata);
	}


	public ListOfPublishers getListOfPublishers() {
		return listOfPublishers;
	}


	@Override
	public void update(UserMetadata publisherMetadata, ForeignInformationFile fif) {
		if (!listOfPublishers.contains(publisherMetadata))
			// FIXME: how to handle this??
			;
		// FIXME: how to do object change
	}


	@Override
	public void acknowledgeSubscription(UserMetadata publisherMetadata) {
		listOfPublishers.changeState(publisherMetadata, SubscriptionState.granted);
	}


	@Override
	public void denySubscription(UserMetadata publisherMetadata) {
		// TODO: what to do here?
	}


	@Override
	public void subscribe(UserId publisherId) {
		remoteCommandExecutor.execute(new AbstractSubscriberRemoteCommand(publisherId) {

			@Override
			public void execute(PublisherStub publisherStub) {
				publisherStub.addObserver(getSubscriberMetadata());
			}

		});
	}

}

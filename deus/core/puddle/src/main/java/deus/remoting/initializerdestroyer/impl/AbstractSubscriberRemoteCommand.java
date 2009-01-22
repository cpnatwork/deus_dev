package deus.remoting.initializerdestroyer.impl;

import deus.core.User;
import deus.core.publisher.PublisherStub;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.transportid.TransportIdType;
import deus.remoting.initializerdestroyer.RemotingState;

public abstract class AbstractSubscriberRemoteCommand extends AbstractRemoteCommand {

	private final PublisherMetadata publisherMetadata;


	public AbstractSubscriberRemoteCommand(PublisherMetadata publisherMetadata, TransportIdType transportIdType) {
		super(transportIdType);
		this.publisherMetadata = publisherMetadata;
	}


	@Override
	public final void execute(User user) {
		RemotingState remotingState = user.getRemotingState(transportIdType);

		// search for the right publisher stub
		for (PublisherStub stub : remotingState.getPublisherStubs())
			if (stub.getPublisherMetadata().equals(publisherMetadata)) {
				execute(stub);
				break;
			}
	}


	public abstract void execute(PublisherStub publisherStub);

}

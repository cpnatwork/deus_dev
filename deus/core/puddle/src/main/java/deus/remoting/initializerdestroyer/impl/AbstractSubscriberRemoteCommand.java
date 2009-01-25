package deus.remoting.initializerdestroyer.impl;

import deus.core.publisher.PublisherStub;
import deus.model.sub.PublisherMetadata;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.initializerdestroyer.RemoteCommand;
import deus.remoting.initializerdestroyer.RemotingState;
import deus.remoting.initializerdestroyer.RemotingStateRegistry;

public abstract class AbstractSubscriberRemoteCommand implements RemoteCommand {

	private final PublisherMetadata publisherMetadata;


	public AbstractSubscriberRemoteCommand(PublisherMetadata publisherMetadata) {
		super();
		this.publisherMetadata = publisherMetadata;
	}


	@Override
	public final void execute(RemotingStateRegistry remotingStateRegistry, TransportIdType transportIdType) {
		RemotingState remotingState = remotingStateRegistry.getRemotingState(transportIdType);

		// search for the right publisher stub
		for (PublisherStub stub : remotingState.getPublisherStubs())
			if (stub.getPublisherMetadata().equals(publisherMetadata)) {
				execute(stub);
				break;
			}
	}


	public abstract void execute(PublisherStub publisherStub);

}

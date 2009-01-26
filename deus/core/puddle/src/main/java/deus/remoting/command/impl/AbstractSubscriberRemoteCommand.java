package deus.remoting.command.impl;

import deus.core.publisher.PublisherStub;
import deus.model.sub.PublisherMetadata;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.command.RemoteCommand;
import deus.remoting.state.RemotingState;
import deus.remoting.state.RemotingStateRegistry;

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

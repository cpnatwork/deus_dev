package deus.remoting.command.impl;

import deus.core.publisher.PublisherStub;
import deus.model.sub.PublisherMetadata;
import deus.remoting.command.RemoteCommand;
import deus.remoting.state.RemotingState;

public abstract class AbstractSubscriberRemoteCommand implements RemoteCommand {

	private final PublisherMetadata publisherMetadata;


	public AbstractSubscriberRemoteCommand(PublisherMetadata publisherMetadata) {
		super();
		this.publisherMetadata = publisherMetadata;
	}


	@Override
	public final void execute(RemotingState remotingState) {
		PublisherStub stub = remotingState.getPublisherStub(publisherMetadata);
		execute(stub);
	}


	public abstract void execute(PublisherStub publisherStub);

}

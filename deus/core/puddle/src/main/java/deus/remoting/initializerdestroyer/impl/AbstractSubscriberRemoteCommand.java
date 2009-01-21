package deus.remoting.initializerdestroyer.impl;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.User;
import deus.core.publisher.PublisherStub;
import deus.model.sub.PublisherMetadata;
import deus.remoting.initializerdestroyer.RemoteCommand;
import deus.remoting.initializerdestroyer.RemotingState;
import deus.remoting.initializerdestroyer.RemotingStateRegistry;

public abstract class AbstractSubscriberRemoteCommand implements RemoteCommand {
	
	private final PublisherMetadata publisherMetadata;

	@Autowired
	private RemotingStateRegistry remotingStateRegistry;


	public AbstractSubscriberRemoteCommand(PublisherMetadata publisherMetadata) {
		this.publisherMetadata = publisherMetadata;
	}


	@Override
	public final void execute(User user) {
		RemotingState remotingState = remotingStateRegistry.getRemotingState(user);

		// search for the right subscriber stub
		for (PublisherStub stub : remotingState.getPublisherStubs())
			if (stub.getPublisherMetadata().equals(publisherMetadata)) {
				execute(stub);
				break;
			}
	}


	public abstract void execute(PublisherStub publisherStub);

}

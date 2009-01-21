package deus.remoting.initializerdestroyer.impl;

import org.springframework.beans.factory.annotation.Autowired;

import deus.core.User;
import deus.core.subscriber.SubscriberStub;
import deus.model.pub.SubscriberMetadata;
import deus.remoting.initializerdestroyer.RemoteCommand;
import deus.remoting.initializerdestroyer.RemotingState;
import deus.remoting.initializerdestroyer.RemotingStateRegistry;

public abstract class AbstractPublisherRemoteCommand implements RemoteCommand {

	private final SubscriberMetadata subscriberMetadata;
	
	@Autowired
	private RemotingStateRegistry remotingStateRegistry;
	
	public AbstractPublisherRemoteCommand(SubscriberMetadata subscriberMetadata) {
		this.subscriberMetadata = subscriberMetadata;
	}
	
	
	@Override
	public final void execute(User user) {
		RemotingState remotingState = remotingStateRegistry.getRemotingState(user);
		
		// search for the right subscriber stub
		for(SubscriberStub stub : remotingState.getSubscriberStubs())
			if(stub.getSubscriberMetadata().equals(subscriberMetadata)) {
				execute(stub);
				break;
			}
	}

	public abstract void execute(SubscriberStub subscriberStub);
	
}

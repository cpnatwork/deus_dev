package deus.remoting.command.impl;

import deus.core.subscriber.SubscriberStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.command.RemoteCommand;
import deus.remoting.state.RemotingState;
import deus.remoting.state.RemotingStateRegistry;

public abstract class AbstractPublisherRemoteCommand implements RemoteCommand {

	private final SubscriberMetadata subscriberMetadata;


	public AbstractPublisherRemoteCommand(SubscriberMetadata subscriberMetadata) {
		super();
		this.subscriberMetadata = subscriberMetadata;
	}


	@Override
	public final void execute(RemotingStateRegistry remotingStateRegistry, TransportIdType transportIdType) {
		RemotingState remotingState = remotingStateRegistry.getRemotingState(transportIdType);

		// search for the right subscriber stub
		for (SubscriberStub stub : remotingState.getSubscriberStubs())
			if (stub.getSubscriberMetadata().equals(subscriberMetadata)) {
				execute(stub);
				break;
			}
	}


	protected abstract void execute(SubscriberStub subscriberStub);

}

package deus.remoting.command.impl;

import deus.core.subscriber.stub.SubscriberStub;
import deus.model.pub.SubscriberMetadata;
import deus.remoting.command.RemoteCommand;
import deus.remoting.state.RemotingState;

public abstract class AbstractPublisherRemoteCommand implements RemoteCommand {

	private final SubscriberMetadata subscriberMetadata;


	public AbstractPublisherRemoteCommand(SubscriberMetadata subscriberMetadata) {
		super();
		this.subscriberMetadata = subscriberMetadata;
	}


	@Override
	public final void execute(RemotingState remotingState) {
		SubscriberStub stub = remotingState.getSubscriberStub(subscriberMetadata);
		execute(stub);
	}


	protected abstract void execute(SubscriberStub subscriberStub);

}

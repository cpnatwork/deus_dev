package deus.remoting.initializerdestroyer.impl;

import deus.core.User;
import deus.core.subscriber.SubscriberStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.initializerdestroyer.RemotingState;

public abstract class AbstractPublisherRemoteCommand extends AbstractRemoteCommand {

	private final SubscriberMetadata subscriberMetadata;


	public AbstractPublisherRemoteCommand(SubscriberMetadata subscriberMetadata, TransportIdType transportIdType) {
		super(transportIdType);
		this.subscriberMetadata = subscriberMetadata;
	}


	@Override
	public final void execute(User user) {
		RemotingState remotingState = user.getRemotingState(transportIdType);

		// search for the right subscriber stub
		for (SubscriberStub stub : remotingState.getSubscriberStubs())
			if (stub.getSubscriberMetadata().equals(subscriberMetadata)) {
				execute(stub);
				break;
			}
	}


	protected abstract void execute(SubscriberStub subscriberStub);

}

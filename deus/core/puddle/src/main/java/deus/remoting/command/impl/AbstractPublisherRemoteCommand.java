package deus.remoting.command.impl;

import deus.core.subscriber.stub.SubscriberStub;
import deus.model.pub.SubscriberMetadata;
import deus.model.user.id.UserId;
import deus.remoting.command.RemoteCommand;
import deus.remoting.state.RemotingState;

/**
 * A remote command, issued by the publisher subsystem.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
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


	@Override
	public UserId getReceiverId() {
		return subscriberMetadata.getUserId();
	}

}

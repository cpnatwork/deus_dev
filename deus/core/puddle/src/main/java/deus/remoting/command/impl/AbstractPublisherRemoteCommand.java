package deus.remoting.command.impl;

import deus.core.subscriber.stub.SubscriberStub;
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

	private final UserId subscriberId;


	public AbstractPublisherRemoteCommand(UserId subscriberId) {
		super();
		this.subscriberId = subscriberId;
	}


	@Override
	public final void execute(RemotingState remotingState) {
		SubscriberStub stub = remotingState.getSubscriberStub(subscriberId);
		execute(stub);
	}


	protected abstract void execute(SubscriberStub subscriberStub);


	@Override
	public UserId getReceiverId() {
		return subscriberId;
	}

}

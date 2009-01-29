package deus.core.transportOLD.command.impl;

import deus.core.soul.subscriber.stub.SubscriberStub;
import deus.core.transportOLD.command.RemoteCommand;
import deus.core.transportOLD.command.Subsystem;
import deus.core.transportOLD.state.RemotingState;
import deus.model.user.id.UserId;

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


	@Override
	public Subsystem getReceiverSubsystem() {
		return Subsystem.subscriber;
	}	

}

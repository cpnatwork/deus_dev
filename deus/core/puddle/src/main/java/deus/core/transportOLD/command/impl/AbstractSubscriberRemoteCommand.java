package deus.core.transportOLD.command.impl;

import deus.core.soul.publisher.stub.PublisherStub;
import deus.core.transportOLD.command.RemoteCommand;
import deus.core.transportOLD.command.Subsystem;
import deus.core.transportOLD.state.RemotingState;
import deus.model.user.id.UserId;

/**
 * A remote command, issued by the subscriber subsystem.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public abstract class AbstractSubscriberRemoteCommand implements RemoteCommand {

	private final UserId publisherId;


	public AbstractSubscriberRemoteCommand(UserId publisherId) {
		super();
		this.publisherId = publisherId;
	}


	@Override
	public final void execute(RemotingState remotingState) {
		PublisherStub stub = remotingState.getPublisherStub(publisherId);
		execute(stub);
	}


	public abstract void execute(PublisherStub publisherStub);


	@Override
	public UserId getReceiverId() {
		return publisherId;
	}


	@Override
	public Subsystem getReceiverSubsystem() {
		return Subsystem.publisher;
	}
	
}

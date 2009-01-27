package deus.remoting.command.impl;

import deus.core.publisher.stub.PublisherStub;
import deus.model.user.id.UserId;
import deus.remoting.command.RemoteCommand;
import deus.remoting.state.RemotingState;

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
}

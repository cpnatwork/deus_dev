package deus.remoting.command;

import deus.model.user.id.UserId;
import deus.remoting.state.RemotingState;

/**
 * All commands, that need remoting implement this interface and do their remote calling in the <code>execute</code>
 * method. An instance of this class is then passed to <code>RemoteCommandExecutor</code>, which uses this method to
 * execute the command.
 * 
 * The passed remoting state can be used to gather parameters of the remoting call, or other classes needed to send
 * messages (e.g. PublisherStubs, SubscriberStubs, ...).
 * 
 * The remote command is agnostic of the transport protocol to use! It just uses the given remoting state, which holds
 * the state of a communication over a specific transport protocol. This remoting state is retrieved by the
 * <code>RemoteCommandExecutor</code>, which also choses the transport protocol to use.
 * 
 * The id of the receiver of the remote command can be retrieved using the method <code>getReceiverId</code>
 * 
 * @see RemoteCommandExecutor
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface RemoteCommand {

	public void execute(RemotingState remotingState);


	public UserId getReceiverId();

}

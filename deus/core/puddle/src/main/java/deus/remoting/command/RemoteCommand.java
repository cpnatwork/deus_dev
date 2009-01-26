package deus.remoting.command;

import deus.remoting.state.RemotingState;

/**
 * All commands, that need remoting implement this interface and do their remote calling in the <code>execute</code>
 * method. An instance of this class is then passed to <code>RemoteCommandExecutor</code>, which calls this method.
 * 
 * The passed remoting state can be used to gather parameters of the remoting call, or other classes needed to send
 * messages (e.g. PublisherStubs, SubscriberStubs, ...).
 * 
 * The remote command is agnostic of the transport protocol to use, to execute the remote command! It just uses the
 * given remoting state, which is specific for a transport protocol.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface RemoteCommand {

	public void execute(RemotingState remotingState);

}

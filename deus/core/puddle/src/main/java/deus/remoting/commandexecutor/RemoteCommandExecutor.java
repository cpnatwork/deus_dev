package deus.remoting.commandexecutor;

import deus.remoting.command.RemoteCommand;

/**
 * Classes implementing this interface are able to execute remote commands on behalf of the user, to whom this
 * <code>RemoteCommandExecutor</code> belongs.
 * 
 * The <code>execute</code> method of a <code>RemoteCommand</code> is called after choosing a transport protocol, based
 * on the ID of the sender and the ID of the receiver. The remoting state for this transport protocol is then retrieved
 * and passed to the <code>execute</code> method of the remote command.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface RemoteCommandExecutor {

	public abstract void execute(RemoteCommand remoteCommand);

}
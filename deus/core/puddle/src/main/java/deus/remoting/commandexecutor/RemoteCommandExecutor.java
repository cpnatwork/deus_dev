package deus.remoting.commandexecutor;

import deus.remoting.command.RemoteCommand;

/**
 * Classes implementing this interface are able to execute remote commands on behalf of the user, to whom this
 * <code>RemoteCommandExecutor</code> belongs.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface RemoteCommandExecutor {

	public abstract void execute(RemoteCommand remoteCommand);


}
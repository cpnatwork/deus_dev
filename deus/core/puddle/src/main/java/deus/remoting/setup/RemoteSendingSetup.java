package deus.remoting.setup;

import deus.core.User;

/**
 * Classes implementing this interface prepare an existing remote connection for sending. After the execution of
 * the method <code>setUp</code>, messages can be sent over the remote connection.
 * 
 * @see RemoteConnectionSetup
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
public interface RemoteSendingSetup {

	public void setUp(User user);


	public void tearDown(User user);

}

package deus.remoting.setup;

import deus.core.User;

/**
 * Classes implementing this interface set up and tear down a remote connection. This connection is afterwards ready to
 * receive calls.
 * 
 * Before sending, a class implementing <code>RemoteSendingSetup</code> must be used to set up sending.
 * 
 * @see RemoteSendingSetup
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface RemoteConnectionSetup {

	public void setUp(User user);


	public void tearDown(User user);

}

package deus.remoting.setup;

import deus.core.User;
import deus.model.user.transportid.TransportIdType;

/**
 * Classes implementing this interface prepare an existing remote connection over a single transport protocol for
 * sending. After the execution of the method <code>setUp</code>, messages can be sent over the remote connection.
 * 
 * There should be one class implementing this interface per transport protocol, which should be supported.
 * 
 * @see RemoteConnectionSetup
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface RemoteSendingSetup {

	public void setUp(User user);


	public void tearDown(User user);


	/**
	 * Returns the transport protocol type, for which sending is set up.
	 * 
	 * @return the transport id type of the protocol, for which sending is set up
	 */
	public TransportIdType getType();

}

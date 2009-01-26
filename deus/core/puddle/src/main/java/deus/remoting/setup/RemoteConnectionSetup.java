package deus.remoting.setup;

import deus.core.User;
import deus.model.user.transportid.TransportIdType;

/**
 * Classes implementing this interface set up and tear down a remote connection for a single transport protocol. This
 * connection is afterwards ready to receive calls.
 * 
 * There should be one class implementing this interface per transport protocol, which should be supported.
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
	
	/**
	 * Returns the transport protocol type, that is set up.
	 * 
	 * @return	the transport id type of the protocol, that is set up
	 */
	public TransportIdType getType();

}

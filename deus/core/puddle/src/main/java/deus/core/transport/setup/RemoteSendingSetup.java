package deus.core.transport.setup;

import deus.core.transport.command.Subsystem;
import deus.core.transport.state.RemotingState;
import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;

/**
 * Classes implementing this interface prepare an existing remote connection over a single transport protocol for
 * sending to a specified subsystem of a specified user. After the execution of the method <code>setUpSending</code>,
 * messages can be sent over the remote connection.
 * 
 * There should be one class implementing this interface per transport protocol, which should be supported.
 * 
 * @see RemoteConnectionSetup
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface RemoteSendingSetup {

	void setUpSending(RemotingState remotingState, UserId receiverId, Subsystem receiverSubsystem);


	void tearDownSending(RemotingState remotingState, UserId receiverId, Subsystem receiverSubsystem);


	/**
	 * Returns the transport protocol type, for which sending is set up.
	 * 
	 * @return the transport id type of the protocol, for which sending is set up
	 */
	public TransportIdType getType();
}

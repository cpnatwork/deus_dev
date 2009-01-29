package deus.core.transport.connectionstate;

public interface ConnectionState {
	
	/**
	 * Whether the connection is setup and ready to send!
	 * 
	 * @return	true, if the connection is ready to send messages
	 */
	public boolean isConnectionEstablished();
	
}

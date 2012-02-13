package deus.core.access.transfer.common.connectionstate;

import deus.core.access.transfer.common.protocol.TransferId;


public interface ConnectionStateRegistry {

	public abstract boolean hasConnectionState(TransferId transferId);


	public abstract void addConnectionState(TransferId transferId, ConnectionState ConnectionState);


	public abstract ConnectionState getConnectionState(TransferId transferId);


	public abstract void removeConnectionState(TransferId transferId);

}

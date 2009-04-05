package deus.core.access.transfer.core.connectionstate;

import deus.core.access.transfer.core.soul.protocol.TransportId;

public interface ConnectionStateRegistry {

	public abstract boolean hasConnectionState(TransportId transportId);


	public abstract void addConnectionState(TransportId transportId, ConnectionState ConnectionState);


	public abstract ConnectionState getConnectionState(TransportId transportId);


	public abstract void removeConnectionState(TransportId transportId);

}

package deus.core.transport.connectionstate;

import deus.core.transport.protocol.TransportId;

public interface ConnectionStateRegistry {

	public abstract boolean hasConnectionState(TransportId transportId);


	public abstract void addConnectionState(TransportId transportId, ConnectionState ConnectionState);


	public abstract ConnectionState getConnectionState(TransportId transportId);


	public abstract void removeConnectionState(TransportId transportId);

}

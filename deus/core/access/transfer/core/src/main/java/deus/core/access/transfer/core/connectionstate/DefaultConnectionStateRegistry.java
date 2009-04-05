package deus.core.access.transfer.core.connectionstate;

import java.util.HashMap;
import java.util.Map;

import deus.core.access.transfer.core.soul.protocol.TransportId;

public class DefaultConnectionStateRegistry implements ConnectionStateRegistry {

	private final Map<TransportId, ConnectionState> connectionStates;


	public DefaultConnectionStateRegistry() {
		this.connectionStates = new HashMap<TransportId, ConnectionState>();
	}


	@Override
	public void addConnectionState(TransportId transportId, ConnectionState connectionState) {
		if (hasConnectionState(transportId))
			throw new IllegalStateException("cannot add connection state for transport id " + transportId
					+ ", there already is a connection state for this transport id");
		
		connectionStates.put(transportId, connectionState);
	}


	@Override
	public ConnectionState getConnectionState(TransportId transportId) {
		if (!hasConnectionState(transportId))
			throw new IllegalStateException("cannot get connection state for transport id " + transportId
					+ ", there is no connection state for this transport id");

		return connectionStates.get(transportId);
	}


	@Override
	public boolean hasConnectionState(TransportId transportId) {
		return connectionStates.containsKey(transportId);
	}


	@Override
	public void removeConnectionState(TransportId transportId) {
		if (!hasConnectionState(transportId))
			throw new IllegalStateException("cannot remove connection state for transport id " + transportId
					+ ", there is no connection state for this transport id");

		connectionStates.remove(transportId);
	}

}

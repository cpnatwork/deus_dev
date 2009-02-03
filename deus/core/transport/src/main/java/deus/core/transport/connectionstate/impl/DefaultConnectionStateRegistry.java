package deus.core.transport.connectionstate.impl;

import java.util.HashMap;
import java.util.Map;

import deus.core.transport.connectionstate.ConnectionState;
import deus.core.transport.connectionstate.ConnectionStateRegistry;
import deus.core.transport.core.protocol.TransportId;

public class DefaultConnectionStateRegistry implements ConnectionStateRegistry {

	private final Map<TransportId, ConnectionState> connectionStates;


	public DefaultConnectionStateRegistry() {
		this.connectionStates = new HashMap<TransportId, ConnectionState>();
	}


	@Override
	public void addConnectionState(TransportId transportId, ConnectionState ConnectionState) {
		if (hasConnectionState(transportId))
			throw new IllegalStateException("cannot add connection state for transport id " + transportId
					+ ", there already is a connection state for this transport id");
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

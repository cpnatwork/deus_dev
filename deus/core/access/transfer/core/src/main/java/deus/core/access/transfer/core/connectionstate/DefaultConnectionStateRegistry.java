package deus.core.access.transfer.core.connectionstate;

import java.util.HashMap;
import java.util.Map;

import deus.core.access.transfer.core.soul.protocol.TransferId;

public class DefaultConnectionStateRegistry implements ConnectionStateRegistry {

	private final Map<TransferId, ConnectionState> connectionStates;


	public DefaultConnectionStateRegistry() {
		this.connectionStates = new HashMap<TransferId, ConnectionState>();
	}


	@Override
	public void addConnectionState(TransferId transferId, ConnectionState connectionState) {
		if (hasConnectionState(transferId))
			throw new IllegalStateException("cannot add connection state for transfer id " + transferId
					+ ", there already is a connection state for this transfer id");
		
		connectionStates.put(transferId, connectionState);
	}


	@Override
	public ConnectionState getConnectionState(TransferId transferId) {
		if (!hasConnectionState(transferId))
			throw new IllegalStateException("cannot get connection state for transfer id " + transferId
					+ ", there is no connection state for this transfer id");

		return connectionStates.get(transferId);
	}


	@Override
	public boolean hasConnectionState(TransferId transferId) {
		return connectionStates.containsKey(transferId);
	}


	@Override
	public void removeConnectionState(TransferId transferId) {
		if (!hasConnectionState(transferId))
			throw new IllegalStateException("cannot remove connection state for transfer id " + transferId
					+ ", there is no connection state for this transfer id");

		connectionStates.remove(transferId);
	}

}

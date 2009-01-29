package deus.core.transport.state.impl;

import java.util.HashMap;
import java.util.Map;

import deus.core.transport.state.RemotingState;
import deus.core.transport.state.RemotingStateRegistry;
import deus.model.user.transportid.TransportIdType;

public class RemotingStateRegistryImpl implements RemotingStateRegistry {

	private Map<TransportIdType, RemotingState> remotingStates;
	
	public RemotingStateRegistryImpl() {
		remotingStates = new HashMap<TransportIdType, RemotingState>();
	}
	
	
	/* (non-Javadoc)
	 * @see deus.core.transport.initializerdestroyer.impl.RemotingStateRegistry#hasRemotingState(deus.model.user.transportid.TransportIdType)
	 */
	public boolean hasRemotingState(TransportIdType transportIdType) {
		return remotingStates.containsKey(transportIdType);
	}
	
	
	/* (non-Javadoc)
	 * @see deus.core.transport.initializerdestroyer.impl.RemotingStateRegistry#addRemotingState(deus.model.user.transportid.TransportIdType, deus.core.transport.initializerdestroyer.RemotingState)
	 */
	public void addRemotingState(TransportIdType transportIdType, RemotingState remotingState) {
		remotingStates.put(transportIdType, remotingState);
	}
	
	
	/* (non-Javadoc)
	 * @see deus.core.transport.initializerdestroyer.impl.RemotingStateRegistry#getRemotingState(deus.model.user.transportid.TransportIdType)
	 */
	public RemotingState getRemotingState(TransportIdType transportIdType) {
		return remotingStates.get(transportIdType);
	}


	/* (non-Javadoc)
	 * @see deus.core.transport.initializerdestroyer.impl.RemotingStateRegistry#removeRemotingState(deus.model.user.transportid.TransportIdType)
	 */
	public void removeRemotingState(TransportIdType transportIdType) {
		remotingStates.remove(transportIdType);
	}

}
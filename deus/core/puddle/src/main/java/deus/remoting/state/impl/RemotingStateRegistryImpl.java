package deus.remoting.state.impl;

import java.util.HashMap;
import java.util.Map;

import deus.model.user.transportid.TransportIdType;
import deus.remoting.state.RemotingState;
import deus.remoting.state.RemotingStateRegistry;

public class RemotingStateRegistryImpl implements RemotingStateRegistry {

	private Map<TransportIdType, RemotingState> remotingStates;
	
	public RemotingStateRegistryImpl() {
		remotingStates = new HashMap<TransportIdType, RemotingState>();
	}
	
	
	/* (non-Javadoc)
	 * @see deus.remoting.initializerdestroyer.impl.RemotingStateRegistry#hasRemotingState(deus.model.user.transportid.TransportIdType)
	 */
	public boolean hasRemotingState(TransportIdType transportIdType) {
		return remotingStates.containsKey(transportIdType);
	}
	
	
	/* (non-Javadoc)
	 * @see deus.remoting.initializerdestroyer.impl.RemotingStateRegistry#addRemotingState(deus.model.user.transportid.TransportIdType, deus.remoting.initializerdestroyer.RemotingState)
	 */
	public void addRemotingState(TransportIdType transportIdType, RemotingState remotingState) {
		remotingStates.put(transportIdType, remotingState);
	}
	
	
	/* (non-Javadoc)
	 * @see deus.remoting.initializerdestroyer.impl.RemotingStateRegistry#getRemotingState(deus.model.user.transportid.TransportIdType)
	 */
	public RemotingState getRemotingState(TransportIdType transportIdType) {
		return remotingStates.get(transportIdType);
	}


	/* (non-Javadoc)
	 * @see deus.remoting.initializerdestroyer.impl.RemotingStateRegistry#removeRemotingState(deus.model.user.transportid.TransportIdType)
	 */
	public void removeRemotingState(TransportIdType transportIdType) {
		remotingStates.remove(transportIdType);
	}

}
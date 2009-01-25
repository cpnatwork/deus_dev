package deus.remoting.initializerdestroyer.impl;

import java.util.HashMap;
import java.util.Map;

import deus.model.user.transportid.TransportIdType;
import deus.remoting.initializerdestroyer.RemotingState;
import deus.remoting.initializerdestroyer.RemotingStateRegistry;

public class RemotingStateRegistryImpl implements RemotingStateRegistry {

	Map<TransportIdType, RemotingState> remotingStates;
	
	/* (non-Javadoc)
	 * @see deus.remoting.initializerdestroyer.impl.RemotingStateRegistry#hasRemotingState(deus.model.user.transportid.TransportIdType)
	 */
	public boolean hasRemotingState(TransportIdType transportIdType) {
		// TODO: change implementation
		if(remotingStates == null)
			remotingStates = new HashMap<TransportIdType, RemotingState>();
		return remotingStates.containsKey(transportIdType);
	}
	
	/* (non-Javadoc)
	 * @see deus.remoting.initializerdestroyer.impl.RemotingStateRegistry#addRemotingState(deus.model.user.transportid.TransportIdType, deus.remoting.initializerdestroyer.RemotingState)
	 */
	public void addRemotingState(TransportIdType transportIdType, RemotingState remotingState) {
		// TODO: change implementation
		if(remotingStates == null)
			remotingStates = new HashMap<TransportIdType, RemotingState>();
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
package deus.remoting.initializerdestroyer;

import deus.model.user.id.transportid.TransportIdType;

@Deprecated
public interface RemotingStateRegistry {

	public TransportBoundRemotingStateRegistry getTransportBoundRemotingStateRegistry(TransportIdType transportIdType);
	
	public void registerTransportBoundRemotingStateRegistry(TransportBoundRemotingStateRegistry registry);

}
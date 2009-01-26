package deus.remoting.state;

import deus.model.user.transportid.TransportIdType;


public interface RemotingStateRegistry {

	public abstract boolean hasRemotingState(TransportIdType transportIdType);


	public abstract void addRemotingState(TransportIdType transportIdType, RemotingState remotingState);


	public abstract RemotingState getRemotingState(TransportIdType transportIdType);


	public abstract void removeRemotingState(TransportIdType transportIdType);

}
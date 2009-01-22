package deus.remoting.initializerdestroyer;

import deus.core.User;

@Deprecated
public interface TransportBoundRemotingStateRegistry {

	public abstract RemotingState getRemotingState(User user);


	public abstract void addRemotingState(User user, RemotingState remotingState);


	public abstract void updateRemotingState(User user, RemotingState remotingState);


	public abstract void removeRemotingState(User user);


	public abstract boolean hasRemotingState(User user);

}

package deus.remoting.state;

import deus.model.user.transportid.TransportIdType;


/**
 * Classes implementing this interface register remoting states of different transport protocols for a user. For each
 * transport protocol, one remoting state may be stored. If there is no remoting state available, which can be checked
 * using the method <code>hasRemotingState</code>, than there is no remoting connection available.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface RemotingStateRegistry {

	public abstract boolean hasRemotingState(TransportIdType transportIdType);


	public abstract void addRemotingState(TransportIdType transportIdType, RemotingState remotingState);


	public abstract RemotingState getRemotingState(TransportIdType transportIdType);


	public abstract void removeRemotingState(TransportIdType transportIdType);

}
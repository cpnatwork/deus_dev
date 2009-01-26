package deus.remoting.tpchoosing;

import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;

/**
 * Classes implementing this strategy offer a way to choose a transport protocol based on the user id of the sender and
 * the receiver.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface TransportProtocolChoosingStrategy {

	public TransportIdType chooseTransportIdType(UserId senderId, UserId receiverId);


}

package deus.remoting.state;

import deus.core.publisher.stub.PublisherStub;
import deus.core.subscriber.stub.SubscriberStub;
import deus.model.user.id.UserId;
import deus.model.user.transportid.TransportIdType;
import deus.remoting.command.Subsystem;

/**
 * Classes implementing this interface store a remoting state for a specific transport protocol for a user. It consists
 * of all the publisher and subscriber stubs, the user needs to communicate to all connected susbcribers and publishers.
 * 
 * All stubs can be retrieved as a list, stubs can be added and the whole list can be cleared.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface RemotingState {

	

	public SubscriberStub getSubscriberStub(UserId subscriberId);


	public void addSubscriberStub(SubscriberStub subscriberStub);


	public void removeSubscriberStub(UserId subscriberId);

	

	public PublisherStub getPublisherStub(UserId publisherId);


	public void addPublisherStub(PublisherStub publisherStub);


	public void removePublisherStub(UserId publisherId);

	

	public TransportIdType getType();


	public boolean isSendingReady(UserId receiverId, Subsystem subsystem);

}

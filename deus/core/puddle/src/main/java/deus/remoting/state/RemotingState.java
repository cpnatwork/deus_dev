package deus.remoting.state;

import java.util.List;

import deus.core.publisher.PublisherStub;
import deus.core.subscriber.SubscriberStub;

/**
 * Classes implementing this interface store a remoting state for a user. It consists of all the publisher and
 * subscriber stubs, the user needs to communicate to all connected susbcribers and publishers.
 * 
 * All stubs can be retrieved as a list, stubs can be added and the whole list can be cleared.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface RemotingState {

	public boolean isRemotingAvailable();


	public List<SubscriberStub> getSubscriberStubs();


	public void addSubscriberStub(SubscriberStub subscriberStub);


	public List<PublisherStub> getPublisherStubs();


	public void addPublisherStub(PublisherStub publisherStub);


	public void clearSubscriberStubList();


	public void clearPublisherStubList();
}

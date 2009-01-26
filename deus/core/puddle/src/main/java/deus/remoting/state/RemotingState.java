package deus.remoting.state;

import java.util.List;

import deus.core.publisher.PublisherStub;
import deus.core.subscriber.SubscriberStub;

public interface RemotingState {

	public boolean isRemotingAvailable();


	public List<SubscriberStub> getSubscriberStubs();


	public void addSubscriberStub(SubscriberStub subscriberStub);


	public List<PublisherStub> getPublisherStubs();


	public void addPublisherStub(PublisherStub publisherStub);


	public void clearSubscriberStubList();


	public void clearPublisherStubList();
}

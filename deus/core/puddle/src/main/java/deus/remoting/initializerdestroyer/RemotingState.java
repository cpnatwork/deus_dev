package deus.remoting.initializerdestroyer;

import java.util.List;

import deus.core.publisher.PublisherStub;
import deus.core.subscriber.SubscriberStub;
import deus.model.user.id.UserIdType;

public interface RemotingState {

	public boolean isRemotingAvailable();
	
	public UserIdType getUserIdType();
	
	public List<SubscriberStub> getSubscriberStubs();
	
	public void addSubscriberStub(SubscriberStub subscriberStub);
	
	public List<PublisherStub> getPublisherStubs();
	
	public void addPublisherStub(PublisherStub publisherStub);
	
	public void clearSubscriberStubList();
	
	public void clearPublisherStubList();
}

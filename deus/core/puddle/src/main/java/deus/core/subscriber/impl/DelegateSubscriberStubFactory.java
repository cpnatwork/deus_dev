package deus.core.subscriber.impl;

import java.util.List;

import deus.core.subscriber.SubscriberStub;
import deus.core.subscriber.SubscriberStubFactory;
import deus.model.pub.SubscriberMetadata;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;
import deus.model.user.id.UserIdType;

/**
 * This implementation of <code>SubscriberStubFactory</code> takes other
 * <code>SubscriberStubFactories</code> and uses the first one, which can handle
 * a <code>createSubscriberStub</code> request for the given type of subscriber
 * id by delegating the request to the <code>createSubscriberStub</code> method
 * of this factory.
 * 
 * The subfactories are set by passing a list of
 * <code>SubscriberStubFactories</code> to the given setter. The subfactories are
 * queried in the order of the list, whether they can handle the create request by
 * checking the <code>canHandle(userIdType)</code> method. The <code>createSubscriberStub</code>
 * method of the first subfactory, that can handle the type of the subscriber id is called
 * and the created <code>SubscriberStub</code> is returned.
 */
// TODO: where to put this class? it needs knowledge of LocalSubscriberStub, XmppSubscriberStub, ...
public class DelegateSubscriberStubFactory implements SubscriberStubFactory {

	private List<SubscriberStubFactory> subfactories;
	
	@Override
	public <Id extends UserId> SubscriberStub<Id> createSubscriberStub(
			SubscriberMetadata<Id> subscriberMetadata,
			PublisherMetadata<Id> publisherMetadata) {
				// TODO: think about this: if there is a possibility to detect, that according to subscriberMetadata
		// and publisherMetadata, both accounts are on the same server, then return a SubscriberStub, which handles all
		// kinds of userIds, but only if their corresponding accounts are on the same server!		
		
		for(SubscriberStubFactory subfactory : subfactories)
			if(subfactory.canHandle(subscriberMetadata.getUserId().getType()))
				subfactory.createSubscriberStub(subscriberMetadata, publisherMetadata);
		throw new RuntimeException("cannot create a SubscriberStubFactory for UserTypeId " +
				subscriberMetadata.getUserId().getType() + ". No applicable subfactory found.");
	}
	
	/**
	 * Set the list of subfactories, which are queried in the list order,
	 * whether they can create a <code>SubscriberStub</code> for the needed type
	 * of subscriber id.
	 * 
	 * @param subfactories
	 *            the list of subfactories being used to delegate the create
	 *            request
	 */
	public void setSubfactories(List<SubscriberStubFactory> subfactories) {
		this.subfactories = subfactories;
	}

	@Override
	public boolean canHandle(UserIdType userIdType) {
		for(SubscriberStubFactory subfactory : subfactories)
			if(subfactory.canHandle(userIdType))
				return true;
		return false;
	}

}

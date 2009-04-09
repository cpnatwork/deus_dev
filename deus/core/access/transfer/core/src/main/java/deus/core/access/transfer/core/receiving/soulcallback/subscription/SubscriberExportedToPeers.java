package deus.core.access.transfer.core.receiving.soulcallback.subscription;

import deus.model.common.dossier.Patch;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;

/**
 * Groups methods of the interface <code>Subscriber</code>, that are called remotely on the informationConsumer subsystem. These
 * methods are e.g. called from an instance of the class <code>XmppSubscriberSkeleton</code>, which is the part of the
 * stub-skeleton pair, that resides on the informationConsumer side.
 * 
 * 
 * @see Subscriber
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface SubscriberExportedToPeers {
	
	// USE CASE: update

	public void update(SubscriberId subscriberId, PublisherId publisherId, Patch patch);

	
	// USE CASE: subscriber initiated connection

	// FIXME: rename this to subscriptionRequestGranted
	public void noticeSubscriptionRequestGranted(SubscriberId subscriberId, PublisherId publisherId);

	// FIXME: rename this to subscriptionRequestDenied
	public void noticeSubscriptionRequestDenied(SubscriberId subscriberId, PublisherId publisherId);
	

	
	
	// USE CASE: publisher initiated connection
	// FIXME: think about renaming this to "offerSubscription"
	public void addPublisher(SubscriberId subscriberId, PublisherId publisherId, UserMetadata publisherMetadata);
	
	
	public void deletePublisher(SubscriberId subscriberId, PublisherId publisherId);

}

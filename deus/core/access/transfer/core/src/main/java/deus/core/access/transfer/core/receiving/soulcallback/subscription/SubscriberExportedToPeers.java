package deus.core.access.transfer.core.receiving.soulcallback.subscription;

import deus.model.common.dossier.Patch;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.id.UserId;

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

	public void update(UserId subscriberId, UserId publisherId, Patch patch);

	
	// USE CASE: subscriber initiated connection

	// FIXME: rename this to subscriptionRequestGranted
	public void noticeSubscriptionRequestGranted(UserId subscriberId, UserId publisherId);

	// FIXME: rename this to subscriptionRequestDenied
	public void noticeSubscriptionRequestDenied(UserId subscriberId, UserId publisherId);
	

	
	
	// USE CASE: publisher initiated connection
	// FIXME: think about renaming this to "offerSubscription"
	public void addPublisher(UserId subscriberId, UserId publisherId, UserMetadata publisherMetadata);
	
	
	public void deletePublisher(UserId subscriberId, UserId publisherId);

}

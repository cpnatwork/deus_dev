/**************************************************************************
 * DACUS: Distributed Address Card Update System
 * ==============================================
 * Copyright (C) 2008-2012 by 
 *   - Christoph P. Neumann (http://www.chr15t0ph.de)
 *   - Florian Rampp
 **************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 **************************************************************************
 * $Id$
 *************************************************************************/
package deus.core.access.transfer.core.receiving.soulcallback.subscription;

import deus.model.common.dossier.Patch;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;

/**
 * Groups methods of the interface <code>Subscriber</code>, that are called
 * remotely on the informationConsumer subsystem. These methods are e.g. called
 * from an instance of the class <code>XmppSubscriberSkeleton</code>, which is
 * the part of the stub-skeleton pair, that resides on the informationConsumer
 * side.
 * 
 * 
 * @see Subscriber
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface SubscriberExportedToPeers {

	// USE CASE: update

	/**
	 * Update.
	 * 
	 * @param subscriberId
	 *            the subscriber id
	 * @param publisherId
	 *            the publisher id
	 * @param patch
	 *            the patch
	 */
	public void update(SubscriberId subscriberId, PublisherId publisherId,
			Patch patch);

	// USE CASE: subscriber initiated connection

	// FIXME: rename this to subscriptionRequestGranted
	/**
	 * Notice subscription request granted.
	 * 
	 * @param subscriberId
	 *            the subscriber id
	 * @param publisherId
	 *            the publisher id
	 */
	public void noticeSubscriptionRequestGranted(SubscriberId subscriberId,
			PublisherId publisherId);

	// FIXME: rename this to subscriptionRequestDenied
	/**
	 * Notice subscription request denied.
	 * 
	 * @param subscriberId
	 *            the subscriber id
	 * @param publisherId
	 *            the publisher id
	 */
	public void noticeSubscriptionRequestDenied(SubscriberId subscriberId,
			PublisherId publisherId);

	// USE CASE: publisher initiated connection
	// FIXME: think about renaming this to "offerSubscription"
	/**
	 * Adds the publisher.
	 * 
	 * @param subscriberId
	 *            the subscriber id
	 * @param publisherId
	 *            the publisher id
	 * @param publisherMetadata
	 *            the publisher metadata
	 */
	public void addPublisher(SubscriberId subscriberId,
			PublisherId publisherId, UserMetadata publisherMetadata);

	/**
	 * Delete publisher.
	 * 
	 * @param subscriberId
	 *            the subscriber id
	 * @param publisherId
	 *            the publisher id
	 */
	public void deletePublisher(SubscriberId subscriberId,
			PublisherId publisherId);

}

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
package deus.core.access.transfer.core.receiving.soulcallback.publication;

import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;

/**
 * Groups methods of the interface <code>Publisher</code>, that are called
 * remotely. These methods are e.g. called from an instance of the class
 * <code>XmppPublisherSkeleton</code>, which is the part of the stub-skeleton
 * pair, that resides on the publisher side.
 * 
 * @see Publisher
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface PublisherExportedToPeers {

	// USE CASE: subscriber initiated connection

	/**
	 * Adds an observer to the set of observers for this object, provided that
	 * it is not the same as some observer already in the set. The order in
	 * which notifications will be delivered to multiple observers is not
	 * specified. See the class comment.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @param subscriberId
	 *            the subscriber id
	 * @param subscriberMetadata
	 *            an observer to be added.
	 */
	public abstract void addSubscriber(PublisherId publisherId,
			SubscriberId subscriberId, UserMetadata subscriberMetadata);

	// USE CASE: subscriber initiated termination

	/**
	 * Deletes an observer from the set of observers of this object. Passing
	 * <CODE>null</CODE> to this method will have no effect.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @param subscriberId
	 *            the subscriber id
	 */
	public abstract void deleteSubscriber(PublisherId publisherId,
			SubscriberId subscriberId);

	// USE CASE: publisher initiated connection

	// FIXME: rename this to subscriptionOfferConfirmed
	/**
	 * Subscription confirmed.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @param subscriberId
	 *            the subscriber id
	 */
	public abstract void subscriptionConfirmed(PublisherId publisherId,
			SubscriberId subscriberId);

	// FIXME: rename this to subscriptionOfferRepelled
	/**
	 * Subscription abstained.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @param subscriberId
	 *            the subscriber id
	 */
	public abstract void subscriptionAbstained(PublisherId publisherId,
			SubscriberId subscriberId);
}

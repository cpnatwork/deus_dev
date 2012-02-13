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
package deus.core.access.transfer.core.sending.command;

import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;

/**
 * Realizes use case "request subscription", "send cancel subscription use case".
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
//FIXME: rename to subscriptionCommandSender in order to reflect subsystem
public interface SubscriberCommandSender {

	// USE CASE: informationConsumer initiated connection/termination
	
	
	// FIXME: rename to requestSubscription, since use case is called like this
	/**
	 * Subscribe.
	 * 
	 * @param subscriberId
	 *            the subscriber id
	 * @param publisherId
	 *            the publisher id
	 * @param subscriberMetadata
	 *            the subscriber metadata
	 */
	public void subscribe(SubscriberId subscriberId, PublisherId publisherId, UserMetadata subscriberMetadata);


	// FIXME: rename to requestSubscription, since use case is called like this
	/**
	 * Unsubscribe.
	 * 
	 * @param subscriberId
	 *            the subscriber id
	 * @param publisherId
	 *            the publisher id
	 */
	public void unsubscribe(SubscriberId subscriberId, PublisherId publisherId);
	
	
	

	// USE CASE: publisher initiated connection (used, when in role informationConsumer)
	
	/**
	 * Confirm subscription offer.
	 * 
	 * @param subscriberId
	 *            the subscriber id
	 * @param publisherId
	 *            the publisher id
	 */
	public void confirmSubscriptionOffer(SubscriberId subscriberId, PublisherId publisherId);


	/**
	 * Repel subscription offer.
	 * 
	 * @param subscriberId
	 *            the subscriber id
	 * @param publisherId
	 *            the publisher id
	 */
	public void repelSubscriptionOffer(SubscriberId subscriberId, PublisherId publisherId);
	
}

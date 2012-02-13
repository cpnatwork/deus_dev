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

import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;

// FIXME: rename to publicationCommandSender in order to reflect subsystem
/**
 * The Interface PublisherCommandSender.
 */
public interface PublisherCommandSender {

	// USE CASE: update
	
	/**
	 * Update.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @param subscriberId
	 *            the subscriber id
	 * @param digitalCard
	 *            the digital card
	 */
	public void update(PublisherId publisherId, SubscriberId subscriberId, DigitalCard digitalCard);

	
	// USE CASE: publisher initiated connection/termination

	/**
	 * Offer subscription.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @param subscriberId
	 *            the subscriber id
	 * @param publisherMetadata
	 *            the publisher metadata
	 */
	public void offerSubscription(PublisherId publisherId, SubscriberId subscriberId, UserMetadata publisherMetadata);

	/**
	 * Cancel subscription.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @param subscriberId
	 *            the subscriber id
	 */
	public void cancelSubscription(PublisherId publisherId, SubscriberId subscriberId);

	

	// USE CASE: informationConsumer initiated connection (used, when in role publisher)
	
	/**
	 * Grant subscription request.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @param subscriberId
	 *            the subscriber id
	 */
	public void grantSubscriptionRequest(PublisherId publisherId, SubscriberId subscriberId);


	/**
	 * Deny subscription request.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @param subscriberId
	 *            the subscriber id
	 */
	public void denySubscriptionRequest(PublisherId publisherId, SubscriberId subscriberId);
	
}

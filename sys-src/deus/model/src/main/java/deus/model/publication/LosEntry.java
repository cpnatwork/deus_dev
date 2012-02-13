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
package deus.model.publication;

import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.SubscriberId;

/**
 * An entry in the list of subscribers.
 * 
 * The primary key is the ID of the publisher who owns the list and the ID of
 * the subscriber who is embodied by the list entry. Only the latter is included
 * in the entity, since this is the discriminator of the weak entity.
 * 
 * 
 * @see ListOfSubscribers
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public class LosEntry {

	/** The subscriber id. */
	private final SubscriberId subscriberId;

	/** The subscriber metadata. */
	private UserMetadata subscriberMetadata;

	/** The publisher side subscription state. */
	private PublisherSideSubscriptionState publisherSideSubscriptionState;

	/**
	 * Instantiates a new los entry.
	 * 
	 * @param subscriberId
	 *            the subscriber id
	 */
	public LosEntry(final SubscriberId subscriberId) {
		this.subscriberId = subscriberId;
	}

	/**
	 * Gets the subscriber id.
	 * 
	 * @return the subscriber id
	 */
	public SubscriberId getSubscriberId() {
		return this.subscriberId;
	}

	/**
	 * Gets the subscriber metadata.
	 * 
	 * @return the subscriber metadata
	 */
	public UserMetadata getSubscriberMetadata() {
		return this.subscriberMetadata;
	}

	/**
	 * Sets the subscriber metadata.
	 * 
	 * @param subscriberMetadata
	 *            the new subscriber metadata
	 */
	public void setSubscriberMetadata(final UserMetadata subscriberMetadata) {
		this.subscriberMetadata = subscriberMetadata;
	}

	/**
	 * Gets the subscription state.
	 * 
	 * @return the subscription state
	 */
	public PublisherSideSubscriptionState getSubscriptionState() {
		return this.publisherSideSubscriptionState;
	}

	/**
	 * Sets the subscription state.
	 * 
	 * @param publisherSideSubscriptionState
	 *            the new subscription state
	 */
	public void setSubscriptionState(
			final PublisherSideSubscriptionState publisherSideSubscriptionState) {
		this.publisherSideSubscriptionState = publisherSideSubscriptionState;
	}

}

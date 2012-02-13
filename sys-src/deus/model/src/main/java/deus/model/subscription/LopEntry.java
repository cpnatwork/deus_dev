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
package deus.model.subscription;

import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;

/**
 * The Class LopEntry.
 */
public class LopEntry {

	/** The publisher id. */
	private final PublisherId publisherId;
	
	/** The publisher metadata. */
	private UserMetadata publisherMetadata;

	/** The subscriber side subscription state. */
	private SubscriberSideSubscriptionState subscriberSideSubscriptionState;


	/**
	 * Instantiates a new lop entry.
	 * 
	 * @param publisherId
	 *            the publisher id
	 */
	public LopEntry(PublisherId publisherId) {
		super();
		this.publisherId = publisherId;
	}


	/**
	 * Gets the publisher id.
	 * 
	 * @return the publisher id
	 */
	public PublisherId getPublisherId() {
		return publisherId;

	}


	/**
	 * Gets the publisher metadata.
	 * 
	 * @return the publisher metadata
	 */
	public UserMetadata getPublisherMetadata() {
		return publisherMetadata;
	}


	/**
	 * Sets the publisher metadata.
	 * 
	 * @param publisherMetadata
	 *            the new publisher metadata
	 */
	public void setPublisherMetadata(UserMetadata publisherMetadata) {
		this.publisherMetadata = publisherMetadata;
	}


	/**
	 * Gets the subscription state.
	 * 
	 * @return the subscription state
	 */
	public SubscriberSideSubscriptionState getSubscriptionState() {
		return subscriberSideSubscriptionState;
	}


	/**
	 * Sets the subscription state.
	 * 
	 * @param subscriberSideSubscriptionState
	 *            the new subscription state
	 */
	public void setSubscriptionState(SubscriberSideSubscriptionState subscriberSideSubscriptionState) {
		this.subscriberSideSubscriptionState = subscriberSideSubscriptionState;
	}

}

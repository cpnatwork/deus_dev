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
package deus.core.access.transfer.common.messages.publication.connection.establish.subscribe;

import deus.model.common.user.UserMetadata;

/**
 * Command, issued by the informationConsumer to initiate a request for a subscription.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public final class RequestSubscriptionMessage extends SubscribeToPublisherMessage {

	/** The subscriber metadata. */
	private final UserMetadata subscriberMetadata;


	/**
	 * Instantiates a new request subscription message.
	 * 
	 * @param subscriberMetadata
	 *            the subscriber metadata
	 */
	public RequestSubscriptionMessage(UserMetadata subscriberMetadata) {
		super();
		this.subscriberMetadata = subscriberMetadata;
	}


	/**
	 * Gets the subscriber metadata.
	 * 
	 * @return the subscriber metadata
	 */
	public UserMetadata getSubscriberMetadata() {
		return subscriberMetadata;
	}

}

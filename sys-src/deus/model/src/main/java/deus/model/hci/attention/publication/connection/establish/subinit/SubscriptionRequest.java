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
package deus.model.hci.attention.publication.connection.establish.subinit;

import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.SubscriberId;
import deus.model.hci.attention.DecisionType;
import deus.model.hci.attention.publication.connection.ConnectionDecisionToMake;

/**
 * The Class SubscriptionRequest.
 */
public class SubscriptionRequest extends ConnectionDecisionToMake {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8171263892659303689L;

	/** The subscriber id. */
	private final SubscriberId subscriberId;

	/** The subscriber metadata. */
	private final UserMetadata subscriberMetadata;

	/**
	 * Instantiates a new subscription request.
	 * 
	 * @param subscriberId
	 *            the subscriber id
	 * @param subscriberMetadata
	 *            the subscriber metadata
	 */
	public SubscriptionRequest(final SubscriberId subscriberId,
			final UserMetadata subscriberMetadata) {
		this.subscriberId = subscriberId;
		this.subscriberMetadata = subscriberMetadata;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.model.hci.attention.BinaryDecisionToMake#getType()
	 */
	@Override
	public DecisionType getType() {
		return DecisionType.subscriberRequest;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.model.hci.attention.AttentionElement#getCatchphare()
	 */
	@Override
	public String getCatchphare() {
		// I18N
		return "Your Contact " + this.getSubscriberMetadata().getFullName()
				+ " requests subscription";
	}

}

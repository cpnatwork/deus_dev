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
package deus.model.hci.attention.publication.connection.establish.pubinit;

import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.hci.attention.DecisionType;
import deus.model.hci.attention.publication.connection.ConnectionDecisionToMake;

// FIXME: rename it to OfferSubscriptionPlea
/**
 * The Class PublisherOffer.
 */
public class PublisherOffer extends ConnectionDecisionToMake {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4513904904616456581L;

	/** The publisher id. */
	private final PublisherId publisherId;

	/** The publisher metadata. */
	private final UserMetadata publisherMetadata;

	/**
	 * Instantiates a new publisher offer.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @param publisherMetadata
	 *            the publisher metadata
	 */
	public PublisherOffer(final PublisherId publisherId,
			final UserMetadata publisherMetadata) {
		this.publisherId = publisherId;
		this.publisherMetadata = publisherMetadata;
	}

	/**
	 * Gets the publisher id.
	 * 
	 * @return the publisher id
	 */
	public PublisherId getPublisherId() {
		return this.publisherId;
	}

	/**
	 * Gets the publisher metadata.
	 * 
	 * @return the publisher metadata
	 */
	public UserMetadata getPublisherMetadata() {
		return this.publisherMetadata;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.model.hci.attention.BinaryDecisionToMake#getType()
	 */
	@Override
	public DecisionType getType() {
		return DecisionType.publisherOffer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.model.hci.attention.AttentionElement#getCatchphare()
	 */
	@Override
	public String getCatchphare() {
		// I18N
		return "Your Contact " + this.getPublisherMetadata().getFullName()
				+ " offers subscription";
	}

}

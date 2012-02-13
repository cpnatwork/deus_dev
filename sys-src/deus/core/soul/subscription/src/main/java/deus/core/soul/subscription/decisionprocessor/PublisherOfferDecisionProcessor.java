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
package deus.core.soul.subscription.decisionprocessor;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers;
import deus.core.access.transfer.core.sending.command.SubscriberCommandSender;
import deus.core.soul.hci.decisionprocessor.AbstractGenericDecisionProcessor;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.SubscriberId;
import deus.model.common.user.id.UserId;
import deus.model.hci.attention.publication.connection.establish.pubinit.PublisherOffer;

// FIXME: rename it to SubscriptionOfferDec...
/**
 * The Class PublisherOfferDecisionProcessor.
 */
public class PublisherOfferDecisionProcessor extends
		AbstractGenericDecisionProcessor<PublisherOffer> {

	/** The subscriber. */
	@Inject
	@Named("targetedPublisher")
	private SubscriberExportedToPeers subscriber;

	/** The subscriber command sender. */
	@Inject
	private SubscriberCommandSender subscriberCommandSender;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.soul.hci.decisionprocessor.AbstractGenericDecisionProcessor
	 * #processImpl(deus.model.common.user.id.UserId,
	 * deus.model.hci.attention.BinaryDecisionToMake)
	 */
	@Override
	protected void processImpl(final UserId userId,
			final PublisherOffer publisherOffer) {
		final UserMetadata publisherMetadata = publisherOffer
				.getPublisherMetadata();

		if (publisherOffer.isDecisionPositive()) {
			this.subscriber.addPublisher(new SubscriberId(userId),
					publisherOffer.getPublisherId(), publisherMetadata);

			this.subscriberCommandSender.confirmSubscriptionOffer(
					new SubscriberId(userId), publisherOffer.getPublisherId());
		} else {
			// do not add observer

			this.subscriberCommandSender.repelSubscriptionOffer(
					new SubscriberId(userId), publisherOffer.getPublisherId());
		}
	}

}

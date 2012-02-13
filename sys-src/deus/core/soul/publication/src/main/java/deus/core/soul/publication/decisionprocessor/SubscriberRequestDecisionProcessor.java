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
package deus.core.soul.publication.decisionprocessor;

import javax.inject.Inject;
import javax.inject.Named;

import deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers;
import deus.core.access.transfer.core.sending.command.PublisherCommandSender;
import deus.core.soul.hci.decisionprocessor.AbstractGenericDecisionProcessor;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.id.UserId;
import deus.model.hci.attention.publication.connection.establish.subinit.SubscriptionRequest;

// FIXME: rename it to SubscriptionRequestDec...
/**
 * The Class SubscriberRequestDecisionProcessor.
 */
@Named
public class SubscriberRequestDecisionProcessor extends
		AbstractGenericDecisionProcessor<SubscriptionRequest> {

	/** The publisher. */
	@Inject
	@Named("targetedPublisher")
	private PublisherExportedToPeers publisher;

	/** The publisher command sender. */
	@Inject
	private PublisherCommandSender publisherCommandSender;

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
			final SubscriptionRequest subscriptionRequest) {
		final UserMetadata subscriberMetadata = subscriptionRequest
				.getSubscriberMetadata();

		final PublisherId publisherId = new PublisherId(userId);

		if (subscriptionRequest.isDecisionPositive()) {
			// FIXME: add this as method to PublisherExportedToDecisionProcessor

			this.publisher.addSubscriber(publisherId,
					subscriptionRequest.getSubscriberId(), subscriberMetadata);

			this.publisherCommandSender.grantSubscriptionRequest(publisherId,
					subscriptionRequest.getSubscriberId());
		} else {
			// FIXME: add this as method to PublisherExportedToDecisionProcessor

			// do not add observer

			this.publisherCommandSender.denySubscriptionRequest(publisherId,
					subscriptionRequest.getSubscriberId());
		}
	}

}

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
package deus.core.soul.publication.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import deus.core.access.storage.api.publication.LosEntryDao;
import deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers;
import deus.core.soul.hci.barker.BarkerExportedToSubsystems;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.hci.attention.BinaryDecisionToMake;
import deus.model.hci.attention.Notice;
import deus.model.hci.attention.publication.connection.establish.pubinit.SubscriptionConfirmedNotice;
import deus.model.hci.attention.publication.connection.establish.pubinit.SubscriptionRepelNotice;
import deus.model.hci.attention.publication.connection.establish.subinit.SubscriptionRequest;
import deus.model.hci.attention.publication.connection.terminate.SubscriberInitiatedTerminationNotice;
import deus.model.publication.LosEntry;

/**
 * The Class PublisherExportedToPeerBarkerProxy.
 */
@Named("publisherProxy")
public class PublisherExportedToPeerBarkerProxy implements
		PublisherExportedToPeers {

	/** The logger. */
	private final Logger logger = LoggerFactory
			.getLogger(PublisherExportedToPeerBarkerProxy.class);

	/** The proxied publisher. */
	@Inject
	@Named("targetedPublisher")
	private PublisherExportedToPeers proxiedPublisher;

	/** The barker. */
	@Inject
	private BarkerExportedToSubsystems barker;

	/** The los entry dao. */
	@Inject
	private LosEntryDao losEntryDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.core.access.transfer.core.receiving.soulcallback.publication.
	 * PublisherExportedToPeers
	 * #addSubscriber(deus.model.common.user.frids.PublisherId,
	 * deus.model.common.user.frids.SubscriberId,
	 * deus.model.common.user.UserMetadata)
	 */
	@Override
	public void addSubscriber(final PublisherId publisherId,
			final SubscriberId subscriberId,
			final UserMetadata subscriberMetadata) {
		this.logger.trace("proxying call to addObserver");

		// PLACE SUBSCRIBER REQUEST
		final BinaryDecisionToMake decision = new SubscriptionRequest(
				subscriberId, subscriberMetadata);
		this.barker.addUnnoticedAttentionElement(publisherId.getUserId(),
				decision);

		this.logger.trace("added {} to barker", decision);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.core.access.transfer.core.receiving.soulcallback.publication.
	 * PublisherExportedToPeers
	 * #deleteSubscriber(deus.model.common.user.frids.PublisherId,
	 * deus.model.common.user.frids.SubscriberId)
	 */
	@Override
	public void deleteSubscriber(final PublisherId publisherId,
			final SubscriberId subscriberId) {
		this.logger.trace("proxying call to deleteObserver");

		// DELETE OBSERVER
		this.proxiedPublisher.deleteSubscriber(publisherId, subscriberId);

		final LosEntry losEntry = this.losEntryDao.getByNaturalId(publisherId,
				subscriberId);

		// PLACE NOTICE
		final UserMetadata subscriberMetadata = losEntry
				.getSubscriberMetadata();
		final Notice notice = new SubscriberInitiatedTerminationNotice(
				subscriberMetadata);
		this.barker.addUnnoticedAttentionElement(publisherId.getUserId(),
				notice);

		this.logger.trace("added {} to barker", notice);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.core.access.transfer.core.receiving.soulcallback.publication.
	 * PublisherExportedToPeers
	 * #subscriptionConfirmed(deus.model.common.user.frids.PublisherId,
	 * deus.model.common.user.frids.SubscriberId)
	 */
	@Override
	public void subscriptionConfirmed(final PublisherId publisherId,
			final SubscriberId subscriberId) {
		this.logger.debug("proxying call to subscriptionConfirmed");

		final LosEntry losEntry = this.losEntryDao.getByNaturalId(publisherId,
				subscriberId);

		// get publisher metadata out of LoP
		final UserMetadata subscriberMetadata = losEntry
				.getSubscriberMetadata();
		final Notice notice = new SubscriptionConfirmedNotice(
				subscriberMetadata);
		this.barker.addUnnoticedAttentionElement(publisherId.getUserId(),
				notice);

		this.logger.debug("added {} to barker", notice);

		this.proxiedPublisher.subscriptionConfirmed(publisherId, subscriberId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.core.access.transfer.core.receiving.soulcallback.publication.
	 * PublisherExportedToPeers
	 * #subscriptionAbstained(deus.model.common.user.frids.PublisherId,
	 * deus.model.common.user.frids.SubscriberId)
	 */
	@Override
	public void subscriptionAbstained(final PublisherId publisherId,
			final SubscriberId subscriberId) {
		this.logger.debug("proxying call to subscriptionAbstained");

		final LosEntry losEntry = this.losEntryDao.getByNaturalId(publisherId,
				subscriberId);

		// get publisher metadata out of LoP
		final UserMetadata subscriberMetadata = losEntry
				.getSubscriberMetadata();
		final Notice notice = new SubscriptionRepelNotice(subscriberMetadata);
		this.barker.addUnnoticedAttentionElement(publisherId.getUserId(),
				notice);

		this.logger.debug("added {} to barker", notice);

		this.proxiedPublisher.subscriptionAbstained(publisherId, subscriberId);
	}

}

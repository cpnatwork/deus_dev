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
package deus.core.soul.subscription.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import deus.core.access.storage.api.subscription.LopEntryDao;
import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers;
import deus.core.soul.hci.barker.BarkerExportedToSubsystems;
import deus.model.common.dossier.Patch;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.hci.attention.BinaryDecisionToMake;
import deus.model.hci.attention.Notice;
import deus.model.hci.attention.publication.UpdateNotice;
import deus.model.hci.attention.publication.connection.establish.pubinit.PublisherOffer;
import deus.model.hci.attention.publication.connection.establish.subinit.SubscriptionRequestDeniedNotice;
import deus.model.hci.attention.publication.connection.establish.subinit.SubscriptionRequestGrantedNotice;
import deus.model.hci.attention.publication.connection.terminate.PublisherInitiatedTerminationNotice;
import deus.model.subscription.LopEntry;

/**
 * The Class SubscriberExportedToPeerBarkerProxy.
 */
@Named("SubscriberProxy")
public class SubscriberExportedToPeerBarkerProxy implements
		SubscriberExportedToPeers {

	/** The logger. */
	private final Logger logger = LoggerFactory
			.getLogger(SubscriberExportedToPeerBarkerProxy.class);

	/** The proxied subscriber. */
	@Inject
	@Named("targetedSubscriber")
	private SubscriberExportedToPeers proxiedSubscriber;

	/** The barker. */
	@Inject
	private BarkerExportedToSubsystems barker;

	/** The lop entry dao. */
	@Inject
	private LopEntryDao lopEntryDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.core.access.transfer.core.receiving.soulcallback.subscription.
	 * SubscriberExportedToPeers
	 * #noticeSubscriptionRequestGranted(deus.model.common
	 * .user.frids.SubscriberId, deus.model.common.user.frids.PublisherId)
	 */
	@Override
	public void noticeSubscriptionRequestGranted(
			final SubscriberId subscriberId, final PublisherId publisherId) {
		this.logger.debug("proxying call to acknowledgeSubscription");

		final LopEntry lopEntry = this.lopEntryDao.getByNaturalId(subscriberId,
				publisherId);

		// get publisher metadata out of LoP
		final UserMetadata publisherMetadata = lopEntry.getPublisherMetadata();
		final Notice notice = new SubscriptionRequestGrantedNotice(
				publisherMetadata);
		this.barker.addUnnoticedAttentionElement(subscriberId.getUserId(),
				notice);

		this.logger.debug("added {} to barker", notice);

		this.proxiedSubscriber.noticeSubscriptionRequestGranted(subscriberId,
				publisherId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.core.access.transfer.core.receiving.soulcallback.subscription.
	 * SubscriberExportedToPeers
	 * #noticeSubscriptionRequestDenied(deus.model.common
	 * .user.frids.SubscriberId, deus.model.common.user.frids.PublisherId)
	 */
	@Override
	public void noticeSubscriptionRequestDenied(
			final SubscriberId subscriberId, final PublisherId publisherId) {
		this.logger.debug("proxying call to denySubscription");

		final LopEntry lopEntry = this.lopEntryDao.getByNaturalId(subscriberId,
				publisherId);

		// get publisher metadata out of LoP
		final UserMetadata publisherMetadata = lopEntry.getPublisherMetadata();
		final Notice notice = new SubscriptionRequestDeniedNotice(
				publisherMetadata);
		this.barker.addUnnoticedAttentionElement(subscriberId.getUserId(),
				notice);

		this.logger.debug("added {} to barker", notice);

		this.proxiedSubscriber.noticeSubscriptionRequestDenied(subscriberId,
				publisherId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.core.access.transfer.core.receiving.soulcallback.subscription.
	 * SubscriberExportedToPeers
	 * #update(deus.model.common.user.frids.SubscriberId,
	 * deus.model.common.user.frids.PublisherId,
	 * deus.model.common.dossier.Patch)
	 */
	@Override
	public void update(final SubscriberId subscriberId,
			final PublisherId publisherId, final Patch patch) {
		this.logger.debug("proxying call to update");

		this.proxiedSubscriber.update(subscriberId, publisherId, patch);

		final LopEntry lopEntry = this.lopEntryDao.getByNaturalId(subscriberId,
				publisherId);
		final Notice notice = new UpdateNotice(lopEntry.getPublisherMetadata(),
				patch);
		this.barker.addUnnoticedAttentionElement(subscriberId.getUserId(),
				notice);

		this.logger.debug("added {} to barker", notice);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.core.access.transfer.core.receiving.soulcallback.subscription.
	 * SubscriberExportedToPeers
	 * #addPublisher(deus.model.common.user.frids.SubscriberId,
	 * deus.model.common.user.frids.PublisherId,
	 * deus.model.common.user.UserMetadata)
	 */
	@Override
	public void addPublisher(final SubscriberId subscriberId,
			final PublisherId publisherId, final UserMetadata publisherMetadata) {
		this.logger.debug("proxying call to addPublisher");

		// PLACE PUBLISHER REQUEST
		final BinaryDecisionToMake decision = new PublisherOffer(publisherId,
				publisherMetadata);
		this.barker.addUnnoticedAttentionElement(subscriberId.getUserId(),
				decision);

		this.logger.trace("added {} to barker", decision);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.core.access.transfer.core.receiving.soulcallback.subscription.
	 * SubscriberExportedToPeers
	 * #deletePublisher(deus.model.common.user.frids.SubscriberId,
	 * deus.model.common.user.frids.PublisherId)
	 */
	@Override
	public void deletePublisher(final SubscriberId subscriberId,
			final PublisherId publisherId) {
		this.logger.debug("proxying call to deletePublisher");

		// DELETE PUBLISHER
		this.proxiedSubscriber.deletePublisher(subscriberId, publisherId);

		final LopEntry lopEntry = this.lopEntryDao.getByNaturalId(subscriberId,
				publisherId);

		// PLACE NOTICE
		final UserMetadata publisherMetadata = lopEntry.getPublisherMetadata();
		final Notice notice = new PublisherInitiatedTerminationNotice(
				publisherMetadata);
		this.barker.addUnnoticedAttentionElement(subscriberId.getUserId(),
				notice);

		this.logger.trace("added {} to barker", notice);
	}

}
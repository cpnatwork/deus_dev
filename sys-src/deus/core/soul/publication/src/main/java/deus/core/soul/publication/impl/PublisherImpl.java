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

import deus.core.access.storage.api.common.user.UserMetadataDao;
import deus.core.access.storage.api.publication.LosDao;
import deus.core.access.storage.api.publication.LosEntryDao;
import deus.core.access.transfer.core.sending.command.PublisherCommandSender;
import deus.core.soul.publication.Publisher;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.publication.ListOfSubscribers;
import deus.model.publication.LosEntry;
import deus.model.publication.PublisherSideSubscriptionState;

/**
 * The Class PublisherImpl.
 */
@Named("targetedPublisher")
public class PublisherImpl implements Publisher {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(PublisherImpl.class);

	/** The publisher command sender. */
	@Inject
	private PublisherCommandSender publisherCommandSender;

	/** The user metadata dao. */
	@Inject
	private UserMetadataDao userMetadataDao;

	/** The los entry dao. */
	@Inject
	private LosEntryDao losEntryDao;

	/** The los dao. */
	@Inject
	private LosDao losDao;

	// FIXME: think about returning a DTO to the frontend here
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.soul.publication.PublisherExportedToClient#getListOfSubscribers
	 * (deus.model.common.user.frids.PublisherId)
	 */
	@Override
	public ListOfSubscribers getListOfSubscribers(final PublisherId publisherId) {
		return this.losDao.getByNaturalId(publisherId);
	}

	// +++ exported to PEER
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

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
	public synchronized void addSubscriber(final PublisherId publisherId,
			final SubscriberId subscriberId,
			final UserMetadata subscriberMetadata) {
		this.logger.trace("adding informationConsumer {}", subscriberId);

		if (this.losEntryDao.existsByNaturalId(publisherId, subscriberId))
			throw new IllegalArgumentException(
					"cannot add informationConsumer, it has already been added!");

		final LosEntry entry = new LosEntry(subscriberId);
		entry.setSubscriberMetadata(subscriberMetadata);
		entry.setSubscriptionState(PublisherSideSubscriptionState.established);

		this.losEntryDao.addNewEntity(publisherId, entry);
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
	public synchronized void deleteSubscriber(final PublisherId publisherId,
			final SubscriberId subscriberId) {
		this.logger.trace("removing informationConsumer {}", subscriberId);

		if (!this.losEntryDao.existsByNaturalId(publisherId, subscriberId))
			throw new IllegalArgumentException(
					"cannot remove informationConsumer, that has not been added yet!");

		this.losEntryDao.deleteByNaturalId(publisherId, subscriberId);
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
		this.logger
				.trace("in publisher of {}: informationConsumer {} confirmed subscription",
						subscriberId, publisherId);

		final LosEntry entry = this.losEntryDao.getByNaturalId(publisherId,
				subscriberId);
		entry.setSubscriptionState(PublisherSideSubscriptionState.established);

		this.losEntryDao.updateEntity(publisherId, entry);
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
		this.logger
				.trace("in publisher of {}: informationConsumer {} abstained subscription",
						subscriberId, publisherId);

		this.losEntryDao.deleteByNaturalId(publisherId, subscriberId);
	}

	// +++ exported to CLIENT
	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.soul.publication.PublisherExportedToClient#notifySubscriber
	 * (deus.model.common.user.frids.PublisherId,
	 * deus.model.common.user.frids.SubscriberId,
	 * deus.model.common.dossier.DigitalCard)
	 */
	@Override
	public synchronized void notifySubscriber(final PublisherId publisherId,
			final SubscriberId subscriberId, final DigitalCard digitalCard) {
		this.logger.trace("notifying subscribers of change {}", digitalCard);

		final LosEntry losEntry = this.losEntryDao.getByNaturalId(publisherId,
				subscriberId);

		this.publisherCommandSender.update(publisherId,
				losEntry.getSubscriberId(), digitalCard);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.soul.publication.PublisherExportedToClient#notifySubscribers
	 * (deus.model.common.user.frids.PublisherId,
	 * deus.model.common.dossier.DigitalCard)
	 */
	@Override
	public void notifySubscribers(final PublisherId publisherId,
			final DigitalCard digitalCard) {
		this.logger.trace("notifying subscribers of change {}", digitalCard);

		final ListOfSubscribers listOfSubscribers = this.losDao
				.getByNaturalId(publisherId);

		/*
		 * a temporary array buffer, used as a snapshot of the state of current
		 * Observers.
		 */
		Object[] arrLocal;

		synchronized (this) {
			/*
			 * We don't want the Observer doing callbacks into arbitrary code
			 * while holding its own Monitor. The code where we extract each
			 * Observable from the Vector and store the state of the Observer
			 * needs synchronization, but notifying observers does not (should
			 * not). The worst result of any potential race-condition here is
			 * that: 1) a newly-added Observer will miss a notification in
			 * progress 2) a recently unregistered Observer will be wrongly
			 * notified when it doesn't care
			 */
			arrLocal = listOfSubscribers.keySet().toArray();
		}

		for (int i = arrLocal.length - 1; i >= 0; i--) {
			// TODO: think about publishing using multiple threads
			final LosEntry losEntry = (LosEntry) arrLocal[i];

			this.publisherCommandSender.update(publisherId,
					losEntry.getSubscriberId(), digitalCard);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.soul.publication.PublisherExportedToClient#inviteSubscriber
	 * (deus.model.common.user.frids.PublisherId,
	 * deus.model.common.user.frids.SubscriberId,
	 * deus.model.common.user.UserMetadata)
	 */
	@Override
	public void inviteSubscriber(final PublisherId publisherId,
			final SubscriberId subscriberId,
			final UserMetadata subscriberMetadata) {
		if (this.losEntryDao.existsByNaturalId(publisherId, subscriberId))
			throw new IllegalArgumentException(
					"cannot offer subscription to informationConsumer ("
							+ subscriberId + ") again!");

		this.logger
				.trace("in publisher {}: offering subscription to informationConsumer {}",
						publisherId, subscriberId);

		final LosEntry entry = new LosEntry(subscriberId);
		entry.setSubscriberMetadata(subscriberMetadata);
		entry.setSubscriptionState(PublisherSideSubscriptionState.offered);
		this.losEntryDao.addNewEntity(publisherId, entry);

		final UserMetadata publisherMetadata = this.userMetadataDao
				.getByNaturalId(publisherId.getUserId());

		this.publisherCommandSender.offerSubscription(publisherId,
				subscriberId, publisherMetadata);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.soul.publication.PublisherExportedToClient#cancelSubscription
	 * (deus.model.common.user.frids.PublisherId,
	 * deus.model.common.user.frids.SubscriberId)
	 */
	@Override
	public void cancelSubscription(final PublisherId publisherId,
			final SubscriberId subscriberId) {
		if (this.losEntryDao.existsByNaturalId(publisherId, subscriberId))
			throw new IllegalArgumentException(
					"cannot cancel a subscription of informationConsumer ("
							+ subscriberId + "), that has not been added yet!");

		this.logger
				.trace("in publisher {}: canceling subscription to informationConsumer {}",
						publisherId, subscriberId);

		this.losEntryDao.deleteByNaturalId(publisherId, subscriberId);

		this.publisherCommandSender.cancelSubscription(publisherId,
				subscriberId);
	}

}

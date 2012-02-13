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

import deus.core.access.storage.api.common.user.UserMetadataDao;
import deus.core.access.storage.api.subscription.LopDao;
import deus.core.access.storage.api.subscription.LopEntryDao;
import deus.core.access.transfer.core.sending.command.SubscriberCommandSender;
import deus.core.soul.difgoverning.DifGovernorExportedToSubsystems;
import deus.core.soul.subscription.Subscriber;
import deus.model.common.dossier.Patch;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.subscription.ListOfPublishers;
import deus.model.subscription.LopEntry;
import deus.model.subscription.SubscriberSideSubscriptionState;

/**
 * The Class SubscriberImpl.
 */
@Named("targetedSubscriber")
public class SubscriberImpl implements Subscriber {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(SubscriberImpl.class);

	/** The user metadata dao. */
	@Inject
	private UserMetadataDao userMetadataDao;

	/** The lop entry dao. */
	@Inject
	private LopEntryDao lopEntryDao;

	/** The lop dao. */
	@Inject
	private LopDao lopDao;

	/** The dif governor. */
	@Inject
	private DifGovernorExportedToSubsystems difGovernor;

	/** The subscriber command sender. */
	@Inject
	private SubscriberCommandSender subscriberCommandSender;


	// +++ exported to PEER +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers#noticeSubscriptionRequestGranted(deus.model.common.user.frids.SubscriberId, deus.model.common.user.frids.PublisherId)
	 */
	@Override
	public void noticeSubscriptionRequestGranted(SubscriberId subscriberId, PublisherId publisherId) {
		logger.trace("in informationConsumer of {}: publisher {} acknowledged subscription", subscriberId, publisherId);

		LopEntry entry = lopEntryDao.getByNaturalId(subscriberId, publisherId);
		entry.setSubscriptionState(SubscriberSideSubscriptionState.established);

		lopEntryDao.updateEntity(subscriberId, entry);
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers#noticeSubscriptionRequestDenied(deus.model.common.user.frids.SubscriberId, deus.model.common.user.frids.PublisherId)
	 */
	@Override
	public void noticeSubscriptionRequestDenied(SubscriberId subscriberId, PublisherId publisherId) {
		logger.trace("in informationConsumer of {}: publisher {} denied subscription", subscriberId, publisherId);

		lopEntryDao.deleteByNaturalId(subscriberId, publisherId);
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers#update(deus.model.common.user.frids.SubscriberId, deus.model.common.user.frids.PublisherId, deus.model.common.dossier.Patch)
	 */
	@Override
	public void update(SubscriberId subscriberId, PublisherId publisherId, Patch patch) {
		if (!patch.getCpId().equals(publisherId))
			throw new IllegalArgumentException("ID of publisher does not match CP ID in passed digital card");

		logger.trace("in informationConsumer {}: updating the DIF for publisher {}", subscriberId, publisherId);

		if (!lopEntryDao.existsByNaturalId(subscriberId, publisherId))
			// FIXME: how to handle this Exception??
			;

		difGovernor.applyPatch(subscriberId, publisherId, patch);
	}
	
	
	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers#addPublisher(deus.model.common.user.frids.SubscriberId, deus.model.common.user.frids.PublisherId, deus.model.common.user.UserMetadata)
	 */
	@Override
	public void addPublisher(SubscriberId subscriberId, PublisherId publisherId, UserMetadata publisherMetadata) {
		logger.trace("in informationConsumer of {}: publisher {} added", subscriberId, publisherId);

		LopEntry entry = new LopEntry(publisherId);
		entry.setPublisherMetadata(publisherMetadata);
		entry.setSubscriptionState(SubscriberSideSubscriptionState.established);

		lopEntryDao.addNewEntity(subscriberId, entry);
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers#deletePublisher(deus.model.common.user.frids.SubscriberId, deus.model.common.user.frids.PublisherId)
	 */
	@Override
	public void deletePublisher(SubscriberId subscriberId, PublisherId publisherId) {
		logger.trace("in informationConsumer of {}: publisher {} deleted", subscriberId, publisherId);

		lopEntryDao.deleteByNaturalId(subscriberId, publisherId);
	}

	

	// +++ exported to CLIENT +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


	// FIXME: think about returning a DTO to the frontend here
	/* (non-Javadoc)
	 * @see deus.core.soul.subscription.SubscriberExportedToClient#getListOfPublishers(deus.model.common.user.frids.SubscriberId)
	 */
	@Override
	public ListOfPublishers getListOfPublishers(SubscriberId subscriberId) {
		ListOfPublishers listOfPublishers = lopDao.getByNaturalId(subscriberId);
		return listOfPublishers;
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.subscription.SubscriberExportedToClient#subscribeToPublisher(deus.model.common.user.frids.SubscriberId, deus.model.common.user.frids.PublisherId, deus.model.common.user.UserMetadata)
	 */
	@Override
	public void subscribeToPublisher(SubscriberId subscriberId, PublisherId publisherId, UserMetadata publisherMetadata) {
		if (lopEntryDao.existsByNaturalId(subscriberId, publisherId))
			throw new IllegalArgumentException("cannot subscribe to publisher (" + publisherId + ") again!");

		logger.trace("in informationConsumer {}: subscribing to publisher {}", subscriberId, publisherId);

		LopEntry entry = new LopEntry(publisherId);
		entry.setPublisherMetadata(publisherMetadata);
		entry.setSubscriptionState(SubscriberSideSubscriptionState.requested);
		lopEntryDao.addNewEntity(subscriberId, entry);

		UserMetadata subscriberMetadata = userMetadataDao.getByNaturalId(subscriberId.getUserId());

		subscriberCommandSender.subscribe(subscriberId, publisherId, subscriberMetadata);
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.subscription.SubscriberExportedToClient#unsubscribe(deus.model.common.user.frids.SubscriberId, deus.model.common.user.frids.PublisherId)
	 */
	@Override
	public void unsubscribe(SubscriberId subscriberId, PublisherId publisherId) {
		if (!lopEntryDao.existsByNaturalId(subscriberId, publisherId))
			throw new IllegalArgumentException("cannot unsubscribe from publisher (" + publisherId
					+ "), that has not been added yet!");

		logger.trace("in informationConsumer {}: unsubscribing from publisher {}", subscriberId, publisherId);

		lopEntryDao.deleteByNaturalId(subscriberId, publisherId);

		subscriberCommandSender.unsubscribe(subscriberId, publisherId);
	}

}

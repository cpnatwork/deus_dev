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

import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers;
import deus.core.soul.subscription.Subscriber;
import deus.core.soul.subscription.SubscriberExportedToClient;
import deus.model.common.dossier.Patch;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.subscription.ListOfPublishers;

/**
 * Delegates all methods of <code>SubscriberExportedToPeers</code> to a delegate
 * of type <code>SubscriberExportedToPeers</code>, the rest of the methods of
 * <code>Subscriber</code> are delegated to the second delegate, which is of
 * type <code>Subscriber</code>.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
@Named("subscriber")
public class ProxiedSubscriberAdapter implements Subscriber {

	/** The subscriber exported to client. */
	@Inject
	private SubscriberExportedToClient subscriberExportedToClient;

	/** The subscriber exported to peers. */
	@Inject
	@Named("proxy")
	private SubscriberExportedToPeers subscriberExportedToPeers;

	// +++ METHODS SUBSCRIBER EXPORTED TO PEER
	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++

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
		this.subscriberExportedToPeers.noticeSubscriptionRequestGranted(
				subscriberId, publisherId);
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
		this.subscriberExportedToPeers.noticeSubscriptionRequestDenied(
				subscriberId, publisherId);
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
		this.subscriberExportedToPeers.update(subscriberId, publisherId, patch);
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
		this.subscriberExportedToPeers.addPublisher(subscriberId, publisherId,
				publisherMetadata);
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
		this.subscriberExportedToPeers.deletePublisher(subscriberId,
				publisherId);
	}

	// +++ METHODS OF SUBSCRIBER EXPORTED TO CLIENT
	// +++++++++++++++++++++++++++++++++++++++++++++++++

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.soul.subscription.SubscriberExportedToClient#subscribeToPublisher
	 * (deus.model.common.user.frids.SubscriberId,
	 * deus.model.common.user.frids.PublisherId,
	 * deus.model.common.user.UserMetadata)
	 */
	@Override
	public void subscribeToPublisher(final SubscriberId subscriberId,
			final PublisherId publisherId, final UserMetadata publisherMetadata) {
		this.subscriberExportedToClient.subscribeToPublisher(subscriberId,
				publisherId, publisherMetadata);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.soul.subscription.SubscriberExportedToClient#unsubscribe(deus
	 * .model.common.user.frids.SubscriberId,
	 * deus.model.common.user.frids.PublisherId)
	 */
	@Override
	public void unsubscribe(final SubscriberId subscriberId,
			final PublisherId publisherId) {
		this.subscriberExportedToClient.unsubscribe(subscriberId, publisherId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * deus.core.soul.subscription.SubscriberExportedToClient#getListOfPublishers
	 * (deus.model.common.user.frids.SubscriberId)
	 */
	@Override
	public ListOfPublishers getListOfPublishers(final SubscriberId subscriberId) {
		return this.subscriberExportedToClient
				.getListOfPublishers(subscriberId);
	}

}

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

import deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers;
import deus.core.soul.publication.Publisher;
import deus.core.soul.publication.PublisherExportedToClient;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.publication.ListOfSubscribers;

/**
 * Delegates all methods of <code>PublisherExportedToPeers</code> to a delegate of type
 * <code>PublisherExportedToPeers</code>, the rest of the methods of <code>Publisher</code> are delegated to the second
 * delegate, which is of type <code>Publisher</code>.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
@Named("publisher")
public class ProxiedPublisherAdapter implements Publisher {

	/** The publisher exported to client. */
	@Inject
	private PublisherExportedToClient publisherExportedToClient;

	/** The publisher exported to peers. */
	@Inject
	@Named("publisherProxy")
	private PublisherExportedToPeers publisherExportedToPeers;


	// +++ exported to PEER +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers#addSubscriber(deus.model.common.user.frids.PublisherId, deus.model.common.user.frids.SubscriberId, deus.model.common.user.UserMetadata)
	 */
	@Override
	public void addSubscriber(PublisherId publisherId, SubscriberId subscriberId, UserMetadata subscriberMetadata) {
		publisherExportedToPeers.addSubscriber(publisherId, subscriberId, subscriberMetadata);
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers#deleteSubscriber(deus.model.common.user.frids.PublisherId, deus.model.common.user.frids.SubscriberId)
	 */
	@Override
	public void deleteSubscriber(PublisherId publisherId, SubscriberId subscriberId) {
		publisherExportedToPeers.deleteSubscriber(publisherId, subscriberId);
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers#subscriptionAbstained(deus.model.common.user.frids.PublisherId, deus.model.common.user.frids.SubscriberId)
	 */
	@Override
	public void subscriptionAbstained(PublisherId publisherId, SubscriberId subscriberId) {
		publisherExportedToPeers.subscriptionAbstained(publisherId, subscriberId);
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers#subscriptionConfirmed(deus.model.common.user.frids.PublisherId, deus.model.common.user.frids.SubscriberId)
	 */
	@Override
	public void subscriptionConfirmed(PublisherId publisherId, SubscriberId subscriberId) {
		publisherExportedToPeers.subscriptionConfirmed(publisherId, subscriberId);
	}


	// +++ exported to CLIENT +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


	/* (non-Javadoc)
	 * @see deus.core.soul.publication.PublisherExportedToClient#getListOfSubscribers(deus.model.common.user.frids.PublisherId)
	 */
	@Override
	public ListOfSubscribers getListOfSubscribers(PublisherId publisherId) {
		return publisherExportedToClient.getListOfSubscribers(publisherId);
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.publication.PublisherExportedToClient#notifySubscriber(deus.model.common.user.frids.PublisherId, deus.model.common.user.frids.SubscriberId, deus.model.common.dossier.DigitalCard)
	 */
	@Override
	public void notifySubscriber(PublisherId publisherId, SubscriberId subscriberId, DigitalCard digitalCard) {
		publisherExportedToClient.notifySubscriber(publisherId, subscriberId, digitalCard);
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.publication.PublisherExportedToClient#notifySubscribers(deus.model.common.user.frids.PublisherId, deus.model.common.dossier.DigitalCard)
	 */
	@Override
	public void notifySubscribers(PublisherId publisherId, DigitalCard digitalCard) {
		publisherExportedToClient.notifySubscribers(publisherId, digitalCard);
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.publication.PublisherExportedToClient#cancelSubscription(deus.model.common.user.frids.PublisherId, deus.model.common.user.frids.SubscriberId)
	 */
	@Override
	public void cancelSubscription(PublisherId publisherId, SubscriberId subscriberId) {
		publisherExportedToClient.cancelSubscription(publisherId, subscriberId);
	}


	/* (non-Javadoc)
	 * @see deus.core.soul.publication.PublisherExportedToClient#inviteSubscriber(deus.model.common.user.frids.PublisherId, deus.model.common.user.frids.SubscriberId, deus.model.common.user.UserMetadata)
	 */
	@Override
	public void inviteSubscriber(PublisherId publisherId, SubscriberId subscriberId, UserMetadata subscriberMetadata) {
		publisherExportedToClient.inviteSubscriber(publisherId, subscriberId, subscriberMetadata);
	}

}

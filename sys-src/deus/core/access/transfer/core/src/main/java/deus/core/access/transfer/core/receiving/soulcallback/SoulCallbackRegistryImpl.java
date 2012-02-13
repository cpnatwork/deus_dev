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
package deus.core.access.transfer.core.receiving.soulcallback;

import javax.inject.Named;

import deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers;
import deus.core.access.transfer.core.receiving.soulcallback.repatriationhub.RepatriationHubExportedToPeers;
import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers;


/**
 * The Class SoulCallbackRegistryImpl.
 */
@Named("soulCallbackRegistry")
public class SoulCallbackRegistryImpl implements SoulCallbackRegistry {

	/** The publisher. */
	private PublisherExportedToPeers publisher;

	/** The subscriber. */
	private SubscriberExportedToPeers subscriber;

	/** The repatriation hub. */
	private RepatriationHubExportedToPeers repatriationHub;

	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.receiving.soulcallback.SoulCallbackRegistry#getPublisher()
	 */
	@Override
	public PublisherExportedToPeers getPublisher() {
		return publisher;
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.receiving.soulcallback.SoulCallbackRegistry#getSubscriber()
	 */
	@Override
	public SubscriberExportedToPeers getSubscriber() {
		return subscriber;
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.receiving.soulcallback.ExportedSoulCallbackRegistry#registerPublisher(deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers)
	 */
	@Override
	public void registerPublisher(PublisherExportedToPeers publisher) {
		this.publisher = publisher;
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.receiving.soulcallback.ExportedSoulCallbackRegistry#registerSubscriber(deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers)
	 */
	@Override
	public void registerSubscriber(SubscriberExportedToPeers subscriber) {
		this.subscriber = subscriber;
	}

	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.receiving.soulcallback.ExportedSoulCallbackRegistry#registerRepatriationHub(deus.core.access.transfer.core.receiving.soulcallback.repatriationhub.RepatriationHubExportedToPeers)
	 */
	@Override
	public void registerRepatriationHub(RepatriationHubExportedToPeers repatriationHub) {
		this.repatriationHub = repatriationHub;
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.core.receiving.soulcallback.SoulCallbackRegistry#getRepatriationHub()
	 */
	@Override
	public RepatriationHubExportedToPeers getRepatriationHub() {
		return repatriationHub;
	}
	
}

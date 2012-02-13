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

import deus.core.access.transfer.core.receiving.soulcallback.publication.PublisherExportedToPeers;
import deus.core.access.transfer.core.receiving.soulcallback.repatriationhub.RepatriationHubExportedToPeers;
import deus.core.access.transfer.core.receiving.soulcallback.subscription.SubscriberExportedToPeers;

/**
 * The Interface ExportedSoulCallbackRegistry.
 */
public interface ExportedSoulCallbackRegistry {

	/**
	 * Register publisher.
	 * 
	 * @param publisher
	 *            the publisher
	 */
	public void registerPublisher(PublisherExportedToPeers publisher);

	/**
	 * Register subscriber.
	 * 
	 * @param subscriber
	 *            the subscriber
	 */
	public void registerSubscriber(SubscriberExportedToPeers subscriber);

	/**
	 * Register repatriation hub.
	 * 
	 * @param repatriationHub
	 *            the repatriation hub
	 */
	public void registerRepatriationHub(RepatriationHubExportedToPeers repatriationHub);

}
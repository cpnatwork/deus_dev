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
package deus.core.soul.subscription;

import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.subscription.ListOfPublishers;

/**
 * Groups methods of the interface <code>Subscriber</code> that trigger remote calls. These methods are implemented
 * using a <code>RemoteCommand</code>, that encapsulates the remote action. The calls are delegated to a
 * <code>PublisherStub</code>, that implements the remote call.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface SubscriberExportedToClient {

	// USE CASE: subscriber initiated connection/termination
	
	/**
	 * Subscribe to publisher.
	 * 
	 * @param subscriberId
	 *            the subscriber id
	 * @param publisherId
	 *            the publisher id
	 * @param publisherMetadata
	 *            the publisher metadata
	 */
	public void subscribeToPublisher(SubscriberId subscriberId, PublisherId publisherId, UserMetadata publisherMetadata);

	// FIXME: rename to unsubscribeFromPublisher
	/**
	 * Unsubscribe.
	 * 
	 * @param subscriberId
	 *            the subscriber id
	 * @param publisherId
	 *            the publisher id
	 */
	public void unsubscribe(SubscriberId subscriberId, PublisherId publisherId);

	
	// DATA MODEL RETRIEVING
	
	/**
	 * Gets the list of publishers.
	 * 
	 * @param subscriberId
	 *            the subscriber id
	 * @return the list of publishers
	 */
	public ListOfPublishers getListOfPublishers(SubscriberId subscriberId);

}

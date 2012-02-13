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
package deus.core.soul.publication;

import deus.model.common.dossier.DigitalCard;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.publication.ListOfSubscribers;

/**
 * Groups methods of the interface <code>Publisher</code> that trigger remote
 * calls. These methods are implemented using a <code>RemoteCommand</code>, that
 * encapsulates the remote action. The calls are delegated to a
 * <code>SubscriberStub</code>, that implements the remote call.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface PublisherExportedToClient {

	// USE CASE: update

	/**
	 * If this object has changed, as indicated by the <code>hasChanged</code>
	 * method, then notify all of its observers and then call the
	 * <code>clearChanged</code> method to indicate that this object has no
	 * longer changed.
	 * <p>
	 * Each observer has its <code>update</code> method called with two
	 * arguments: this observable object and the <code>arg</code> argument.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @param digitalCard
	 *            the digital card
	 * @see java.util.Observable#clearChanged()
	 * @see java.util.Observable#hasChanged()
	 * @see java.util.Observer#update(java.util.Observable,
	 *      java.lang.ForeignInformationFile)
	 */
	// FIXME: replace DC parameter by Patch parameter
	public abstract void notifySubscribers(PublisherId publisherId,
			DigitalCard digitalCard);

	// FIXME: replace DC parameter by Patch parameter
	/**
	 * Notify subscriber.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @param subscriberId
	 *            the subscriber id
	 * @param digitalCard
	 *            the digital card
	 */
	public abstract void notifySubscriber(PublisherId publisherId,
			SubscriberId subscriberId, DigitalCard digitalCard);

	// USE CASE: publisher initiated connection/termination

	/**
	 * Invite subscriber.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @param subscriberId
	 *            the subscriber id
	 * @param subscriberMetadata
	 *            the subscriber metadata
	 */
	public abstract void inviteSubscriber(PublisherId publisherId,
			SubscriberId subscriberId, UserMetadata subscriberMetadata);

	/**
	 * Cancel subscription.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @param subscriberId
	 *            the subscriber id
	 */
	public abstract void cancelSubscription(PublisherId publisherId,
			SubscriberId subscriberId);

	// DATA MODEL RETRIEVING

	/**
	 * Gets the list of subscribers.
	 * 
	 * @param publisherId
	 *            the publisher id
	 * @return the list of subscribers
	 */
	public abstract ListOfSubscribers getListOfSubscribers(
			PublisherId publisherId);

}

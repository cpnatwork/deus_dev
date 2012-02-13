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
package deus.core.access.storage.api.archive.sub.model;

import java.util.HashMap;

import deus.model.common.user.id.UserId;
import deus.model.subscription.ListOfPublishers;
import deus.model.subscription.LopEntry;
import deus.model.subscription.SubscriberSideSubscriptionState;

// TODO: think about thread safety! (before, this was implemented using a Vector!)
/**
 * The Class ListOfPublishersImpl.
 */
public class ListOfPublishersImpl extends HashMap<UserId, LopEntry> implements ListOfPublishers {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4125982682692931045L;


	/* (non-Javadoc)
	 * @see deus.model.subscription.ListOfPublishers#changeState(deus.model.common.user.id.UserId, deus.model.subscription.SubscriberSideSubscriptionState)
	 */
	@Override
	public void changeState(UserId publisherId, SubscriberSideSubscriptionState subscriberSideSubscriptionState) {
		if (!containsKey(publisherId))
			throw new IllegalArgumentException("cannot change state of publisher " + publisherId
					+ ", it is not on the list!");
		get(publisherId).setSubscriptionState(subscriberSideSubscriptionState);
	}


	/* (non-Javadoc)
	 * @see deus.model.subscription.ListOfPublishers#getOwnerId()
	 */
	@Override
	public UserId getOwnerId() {
		// TODO Auto-generated method stub
		return null;
	}

}

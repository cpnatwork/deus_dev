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
package deus.model.hci.attention.publication.connection.establish.pubinit;

import deus.model.common.user.UserMetadata;

/**
 * The Class SubscriptionConfirmedNotice.
 */
public class SubscriptionConfirmedNotice extends
		PublisherInitiatedConnectionNotice {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3151688636889099918L;

	/**
	 * Instantiates a new subscription confirmed notice.
	 * 
	 * @param subscriberMetadata
	 *            the subscriber metadata
	 */
	public SubscriptionConfirmedNotice(final UserMetadata subscriberMetadata) {
		super(subscriberMetadata);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.model.hci.attention.AttentionElement#getCatchphare()
	 */
	@Override
	public String getCatchphare() {
		// TODO Auto-generated method stub
		return null;
	}

}

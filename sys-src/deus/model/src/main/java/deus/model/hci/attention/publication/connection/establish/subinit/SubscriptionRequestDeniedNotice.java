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
package deus.model.hci.attention.publication.connection.establish.subinit;

import deus.model.common.user.UserMetadata;

/**
 * The Class SubscriptionRequestDeniedNotice.
 */
public class SubscriptionRequestDeniedNotice extends
		SubscriberInitiatedConnectionNotice {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8520274557666365600L;

	/**
	 * Instantiates a new subscription request denied notice.
	 * 
	 * @param publisherMetadata
	 *            the publisher metadata
	 */
	public SubscriptionRequestDeniedNotice(final UserMetadata publisherMetadata) {
		super(publisherMetadata);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see deus.model.hci.attention.AttentionElement#getCatchphare()
	 */
	@Override
	public String getCatchphare() {
		// I18N
		return "Your subscription request to "
				+ this.getPublisherMetadata().getFullName()
				+ " has been denied";
	}

}

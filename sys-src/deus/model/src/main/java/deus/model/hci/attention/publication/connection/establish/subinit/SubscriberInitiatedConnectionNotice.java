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
import deus.model.hci.attention.publication.connection.ConnectionNotice;

/**
 * The Class SubscriberInitiatedConnectionNotice.
 */
public abstract class SubscriberInitiatedConnectionNotice extends
		ConnectionNotice {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4519369212808949149L;
	/** The publisher metadata. */
	private final UserMetadata publisherMetadata;

	/**
	 * Instantiates a new subscriber initiated connection notice.
	 * 
	 * @param publisherMetadata
	 *            the publisher metadata
	 */
	public SubscriberInitiatedConnectionNotice(
			final UserMetadata publisherMetadata) {
		super();
		this.publisherMetadata = publisherMetadata;
	}

	/**
	 * Gets the publisher metadata.
	 * 
	 * @return the publisher metadata
	 */
	public UserMetadata getPublisherMetadata() {
		return this.publisherMetadata;
	}

}

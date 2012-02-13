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
package deus.model.hci.attention.publication.connection.terminate;

import deus.model.common.user.UserMetadata;

/**
 * The Class PublisherInitiatedTerminationNotice.
 */
public class PublisherInitiatedTerminationNotice extends TerminationNotice {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6022719966833043342L;
	/** The publisher metadata. */
	private final UserMetadata publisherMetadata;

	/**
	 * Instantiates a new publisher initiated termination notice.
	 * 
	 * @param publisherMetadata
	 *            the publisher metadata
	 */
	public PublisherInitiatedTerminationNotice(
			final UserMetadata publisherMetadata) {
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

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
package deus.model.hci.attention.publication;

import deus.model.common.dossier.Patch;
import deus.model.common.user.UserMetadata;
import deus.model.hci.attention.Notice;

/**
 * The Class UpdateNotice.
 */
public class UpdateNotice extends Notice {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5786205944582924302L;

	/** The publisher metadata. */
	private final UserMetadata publisherMetadata;

	/** The patch. */
	private final Patch patch;

	/**
	 * Instantiates a new update notice.
	 * 
	 * @param publisherMetadata
	 *            the publisher metadata
	 * @param patch
	 *            the patch
	 */
	public UpdateNotice(final UserMetadata publisherMetadata, final Patch patch) {
		super();
		this.publisherMetadata = publisherMetadata;
		this.patch = patch;
	}

	/**
	 * Gets the publisher metadata.
	 * 
	 * @return the publisher metadata
	 */
	public UserMetadata getPublisherMetadata() {
		return this.publisherMetadata;
	}

	/**
	 * Gets the patch.
	 * 
	 * @return the patch
	 */
	public Patch getPatch() {
		return this.patch;
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

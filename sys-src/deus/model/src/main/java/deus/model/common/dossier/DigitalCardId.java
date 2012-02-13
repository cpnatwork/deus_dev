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
package deus.model.common.dossier;

import deus.model.common.user.id.UserId;

/**
 * The Class DigitalCardId.
 */
public class DigitalCardId {

	/** The contributor id. */
	private final UserId contributorId;

	/** The cp id. */
	private final UserId cpId;

	/** The contributor provided discriminator. */
	private final String contributorProvidedDiscriminator;

	/**
	 * Instantiates a new digital card id.
	 * 
	 * @param contributorId
	 *            the contributor id
	 * @param cpId
	 *            the cp id
	 * @param contributorProvidedDiscriminator
	 *            the contributor provided discriminator
	 */
	public DigitalCardId(final UserId contributorId, final UserId cpId,
			final String contributorProvidedDiscriminator) {
		super();
		this.contributorId = contributorId;
		this.cpId = cpId;
		this.contributorProvidedDiscriminator = contributorProvidedDiscriminator;
	}

	/**
	 * Gets the contributor id.
	 * 
	 * @return the contributor id
	 */
	public UserId getContributorId() {
		return this.contributorId;
	}

	/**
	 * Gets the cp id.
	 * 
	 * @return the cp id
	 */
	public UserId getCpId() {
		return this.cpId;
	}

	/**
	 * Gets the contributor provided discriminator.
	 * 
	 * @return the contributor provided discriminator
	 */
	public String getContributorProvidedDiscriminator() {
		return this.contributorProvidedDiscriminator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result)
				+ ((this.contributorId == null) ? 0 : this.contributorId
						.hashCode());
		result = (prime * result)
				+ ((this.contributorProvidedDiscriminator == null) ? 0
						: this.contributorProvidedDiscriminator.hashCode());
		result = (prime * result)
				+ ((this.cpId == null) ? 0 : this.cpId.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		final DigitalCardId other = (DigitalCardId) obj;
		if (this.contributorId == null) {
			if (other.contributorId != null)
				return false;
		} else if (!this.contributorId.equals(other.contributorId))
			return false;
		if (this.contributorProvidedDiscriminator == null) {
			if (other.contributorProvidedDiscriminator != null)
				return false;
		} else if (!this.contributorProvidedDiscriminator
				.equals(other.contributorProvidedDiscriminator))
			return false;
		if (this.cpId == null) {
			if (other.cpId != null)
				return false;
		} else if (!this.cpId.equals(other.cpId))
			return false;
		return true;
	}

}

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

/**
 * The Class DigitalCard.
 */
public abstract class DigitalCard {

	/** The digital card id. */
	private final DigitalCardId digitalCardId;

	/** The label. */
	private String label;

	// TODO: add dates (creation date? but what about merge operations when
	// adding it to a PIF/FIF)

	/**
	 * Instantiates a new digital card.
	 * 
	 * @param digitalCardId
	 *            the digital card id
	 */
	public DigitalCard(final DigitalCardId digitalCardId) {
		super();
		this.digitalCardId = digitalCardId;
	}

	/**
	 * Gets the digital card id.
	 * 
	 * @return the digital card id
	 */
	public DigitalCardId getDigitalCardId() {
		return this.digitalCardId;
	}

	/**
	 * Gets the label.
	 * 
	 * @return the label
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * Sets the label.
	 * 
	 * @param label
	 *            the new label
	 */
	public void setLabel(final String label) {
		this.label = label;
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
				+ ((this.digitalCardId == null) ? 0 : this.digitalCardId
						.hashCode());
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
		final DigitalCard other = (DigitalCard) obj;
		if (this.digitalCardId == null) {
			if (other.digitalCardId != null)
				return false;
		} else if (!this.digitalCardId.equals(other.digitalCardId))
			return false;
		return true;
	}

}

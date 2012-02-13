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
package deus.model.dccontent.party.common;

/**
 * The Class EntityTag.
 */
public class EntityTag {

	/** The pers prof tag. */
	private PersProfTag persProfTag;

	/** The label. */
	private String label;

	/** The priority. */
	private int priority;

	/**
	 * Gets the pers prof tag.
	 * 
	 * @return the pers prof tag
	 */
	public PersProfTag getPersProfTag() {
		return this.persProfTag;
	}

	/**
	 * Sets the pers prof tag.
	 * 
	 * @param persProfTag
	 *            the new pers prof tag
	 */
	public void setPersProfTag(final PersProfTag persProfTag) {
		this.persProfTag = persProfTag;
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

	/**
	 * Gets the priority.
	 * 
	 * @return the priority
	 */
	public int getPriority() {
		return this.priority;
	}

	/**
	 * Sets the priority.
	 * 
	 * @param priority
	 *            the new priority
	 */
	public void setPriority(final int priority) {
		this.priority = priority;
	}

}

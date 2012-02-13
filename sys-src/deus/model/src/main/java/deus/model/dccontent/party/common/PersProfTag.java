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
 * The Class PersProfTag.
 */
public class PersProfTag {

	/** The personal. */
	private boolean personal;

	/** The professional. */
	private boolean professional;

	/**
	 * Checks if is personal.
	 * 
	 * @return true, if is personal
	 */
	public boolean isPersonal() {
		return this.personal;
	}

	/**
	 * Sets the personal.
	 * 
	 * @param personal
	 *            the new personal
	 */
	public void setPersonal(final boolean personal) {
		this.personal = personal;
	}

	/**
	 * Checks if is professional.
	 * 
	 * @return true, if is professional
	 */
	public boolean isProfessional() {
		return this.professional;
	}

	/**
	 * Sets the professional.
	 * 
	 * @param professional
	 *            the new professional
	 */
	public void setProfessional(final boolean professional) {
		this.professional = professional;
	}

}

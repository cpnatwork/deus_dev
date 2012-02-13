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

import java.util.Date;

/**
 * The Class DatePlace.
 */
public class DatePlace {

	/** The date. */
	private Date date;

	/** The place. */
	private String place;

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 * Sets the date.
	 * 
	 * @param date
	 *            the new date
	 */
	public void setDate(final Date date) {
		this.date = date;
	}

	/**
	 * Gets the place.
	 * 
	 * @return the place
	 */
	public String getPlace() {
		return this.place;
	}

	/**
	 * Sets the place.
	 * 
	 * @param place
	 *            the new place
	 */
	public void setPlace(final String place) {
		this.place = place;
	}

}

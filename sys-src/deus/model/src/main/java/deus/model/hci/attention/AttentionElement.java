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
package deus.model.hci.attention;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class AttentionElement.
 */
public abstract class AttentionElement implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8703358479824099313L;

	/** The id. */
	private Integer id;

	/** The creation date. */
	private Date creationDate;

	/** The noticed. */
	private boolean noticed;

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * Gets the creation date.
	 * 
	 * @return the creation date
	 */
	public final Date getCreationDate() {
		return this.creationDate;
	}

	/**
	 * Sets the creation date.
	 * 
	 * @param creationDate
	 *            the new creation date
	 */
	public final void setCreationDate(final Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Checks if is noticed.
	 * 
	 * @return true, if is noticed
	 */
	public boolean isNoticed() {
		return this.noticed;
	}

	/**
	 * Sets the noticed.
	 * 
	 * @param noticed
	 *            the new noticed
	 */
	public void setNoticed(final boolean noticed) {
		this.noticed = noticed;
	}

	/**
	 * Gets the catchphare.
	 * 
	 * @return the catchphare
	 */
	public abstract String getCatchphare();

}

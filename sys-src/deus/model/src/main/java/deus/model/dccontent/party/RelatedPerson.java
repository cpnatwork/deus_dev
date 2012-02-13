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
package deus.model.dccontent.party;

import java.net.URL;

/**
 * The Class RelatedPerson.
 */
public class RelatedPerson {

	// TODO: which type should id take?
	/** The reference. */
	private URL reference;

	/** The type. */
	private RelatedPersonType type;


	/**
	 * Gets the reference.
	 * 
	 * @return the reference
	 */
	public URL getReference() {
		return reference;
	}


	/**
	 * Sets the reference.
	 * 
	 * @param reference
	 *            the new reference
	 */
	public void setReference(URL reference) {
		this.reference = reference;
	}


	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public RelatedPersonType getType() {
		return type;
	}


	/**
	 * Sets the type.
	 * 
	 * @param type
	 *            the new type
	 */
	public void setType(RelatedPersonType type) {
		this.type = type;
	}

}

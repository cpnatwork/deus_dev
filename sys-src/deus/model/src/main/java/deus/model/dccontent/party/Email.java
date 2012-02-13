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

import deus.model.dccontent.party.common.EntityTag;

/**
 * The Class Email.
 */
public class Email {

	/** The entity tag. */
	private EntityTag entityTag;

	/** The address. */
	private String address;

	/** The send html. */
	private boolean sendHTML;


	/**
	 * Gets the entity tag.
	 * 
	 * @return the entity tag
	 */
	public EntityTag getEntityTag() {
		return entityTag;
	}


	/**
	 * Sets the entity tag.
	 * 
	 * @param entityTag
	 *            the new entity tag
	 */
	public void setEntityTag(EntityTag entityTag) {
		this.entityTag = entityTag;
	}


	/**
	 * Gets the address.
	 * 
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * Sets the address.
	 * 
	 * @param address
	 *            the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * Checks if is send html.
	 * 
	 * @return true, if is send html
	 */
	public boolean isSendHTML() {
		return sendHTML;
	}


	/**
	 * Sets the send html.
	 * 
	 * @param sendHTML
	 *            the new send html
	 */
	public void setSendHTML(boolean sendHTML) {
		this.sendHTML = sendHTML;
	}

}

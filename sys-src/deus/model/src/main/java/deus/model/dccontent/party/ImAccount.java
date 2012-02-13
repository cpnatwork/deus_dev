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
 * The Class ImAccount.
 */
public class ImAccount {

	/** The entity tag. */
	private EntityTag entityTag;

	/** The type. */
	private ImAccountType type;
	
	/** The account. */
	private String account;


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
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public ImAccountType getType() {
		return type;
	}


	/**
	 * Sets the type.
	 * 
	 * @param type
	 *            the new type
	 */
	public void setType(ImAccountType type) {
		this.type = type;
	}


	/**
	 * Gets the account.
	 * 
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}


	/**
	 * Sets the account.
	 * 
	 * @param account
	 *            the new account
	 */
	public void setAccount(String account) {
		this.account = account;
	}

}

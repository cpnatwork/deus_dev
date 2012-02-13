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
package deus.core.access.storage.api.common.user.model;

import java.io.Serializable;
import java.util.UUID;

/**
 * A local user. It requires a existing UserPO.
 * 
 * @author cpn
 *
 */
@SuppressWarnings("serial")
// FIXME: REMOVE HIBERNATE STUFF HERE
//@Entity
public class LocalUserPO implements Serializable {

	/** The uuid. */
	private UUID uuid;
	
	/** The user po. */
	private UserPO userPO = null;


//	@Id
//	@GeneratedValue(generator = "system-uuid")
//	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	/**
 * Gets the uuid.
 * 
 * @return the uuid
 */
public UUID getUuid() {
		return uuid;
	}


	/**
	 * Sets the uuid.
	 * 
	 * @param uuid
	 *            the new uuid
	 */
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

//	@NaturalId
	/**
 * Gets the id.
 * 
 * @return the id
 */
public String getId() {
		return getUserPO().getUserId().getId();
	}

//	@OneToOne
//	@PrimaryKeyJoinColumn
	/**
 * Gets the user po.
 * 
 * @return the user po
 */
public UserPO getUserPO() {
		return userPO;
	}


	/**
	 * Sets the user po.
	 * 
	 * @param userIdPO
	 *            the new user po
	 */
	public void setUserPO(UserPO userIdPO) {
		this.userPO = userIdPO;
	}

}

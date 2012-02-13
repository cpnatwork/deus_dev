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

import java.util.UUID;

import deus.model.common.user.Gender;
import deus.model.common.user.UserMetadata;


// FIXME: REMOVE HIBERNATE STUFF FROM THIS CLASS
//@Entity
/**
 * The Class UserMetadataPO.
 */
public class UserMetadataPO extends UserMetadata {

	/** The uuid. */
	private UUID uuid;


	/**
	 * Instantiates a new user metadata po.
	 */
	public UserMetadataPO() {
		this.setFullName("N/A");
		this.setGender(Gender.unknown);
	}


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


	/**
	 * Update all attributes by the given value object.
	 * 
	 * @param userMetadata
	 *            the user metadata
	 */
	public void update(UserMetadata userMetadata) {
		this.setFullName(userMetadata.getFullName());
		this.setGender(userMetadata.getGender());
	}
}

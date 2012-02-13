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

import deus.model.common.user.id.UserId;

/**
 * The Class UserPO.
 */
@SuppressWarnings("serial")
// FIXME: REMOVE HIBERNATE STUFF FROM THIS CLASS
// @Entity
public class UserPO implements Serializable {

	/** The uuid. */
	private UUID uuid;

	/** The user id. */
	private UserId userId = null;

	/** The user metadata po. */
	private UserMetadataPO userMetadataPO = null;

	// @Id
	// @GeneratedValue(generator = "system-uuid")
	// @GenericGenerator(name = "system-uuid", strategy = "uuid")
	/**
	 * Gets the uuid.
	 * 
	 * @return the uuid
	 */
	public UUID getUuid() {
		return this.uuid;
	}

	/**
	 * Sets the uuid.
	 * 
	 * @param uuid
	 *            the new uuid
	 */
	public void setUuid(final UUID uuid) {
		this.uuid = uuid;
	}

	// @NaturalId
	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId() {
		return this.userId.getId();
	}

	// @OneToOne
	// @PrimaryKeyJoinColumn
	/**
	 * Gets the user id.
	 * 
	 * @return the user id
	 */
	public UserId getUserId() {
		return this.userId;
	}

	/**
	 * Sets the user id.
	 * 
	 * @param userId
	 *            the new user id
	 */
	public void setUserId(final UserId userId) {
		this.userId = userId;
	}

	// @OneToOne
	// @PrimaryKeyJoinColumn
	/**
	 * Gets the user metadata po.
	 * 
	 * @return the user metadata po
	 */
	public UserMetadataPO getUserMetadataPO() {
		return this.userMetadataPO;
	}

	/**
	 * Sets the user metadata po.
	 * 
	 * @param userMetadata
	 *            the new user metadata po
	 */
	public void setUserMetadataPO(final UserMetadataPO userMetadata) {
		this.userMetadataPO = userMetadata;
	}

}

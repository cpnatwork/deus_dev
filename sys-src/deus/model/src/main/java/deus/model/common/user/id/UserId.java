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
package deus.model.common.user.id;

import java.io.Serializable;

/**
 * The Class UserId.
 */
@SuppressWarnings("serial")
abstract public class UserId implements Serializable {

	/** The username. */
	private String username = null;

	/**
	 * Instantiates a new user id.
	 * 
	 * @param username
	 *            the username
	 */
	public UserId(final String username) {
		super();
		this.username = username;
	}

	/**
	 * The essential user name.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return this.username;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result)
				+ ((this.username == null) ? 0 : this.username.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		final UserId other = (UserId) obj;
		if (this.username == null) {
			if (other.username != null)
				return false;
		} else if (!this.username.equals(other.username))
			return false;
		return true;
	}

	/**
	 * The type of the User ID.
	 * 
	 * @return the type
	 */
	abstract public UserIdType getType();

	/**
	 * The full-fledged String representation of the User ID.
	 * 
	 * @return the id
	 */
	abstract public String getId();

}

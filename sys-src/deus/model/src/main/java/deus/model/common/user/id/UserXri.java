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


//FIXME: REMOVE HIBERNATE STUFF!
//@SuppressWarnings("serial")
//@Entity
/**
 * The Class UserXri.
 */
public class UserXri extends UserId {

	/**
	 * Instantiates a new user xri.
	 * 
	 * @param xri
	 *            the xri
	 */
	public UserXri(String xri) {
		// FIXME: what is the username of an xri?
		super(xri);
	}


	/**
	 * Gets the xri.
	 * 
	 * @return the xri
	 */
	public String getXri() {
		return getUsername();
	}


	/* (non-Javadoc)
	 * @see deus.model.common.user.id.UserId#getType()
	 */
	@Override
	public UserIdType getType() {
		return UserIdType.xri;
	}


	/* (non-Javadoc)
	 * @see deus.model.common.user.id.UserId#getId()
	 */
	@Override
	public String getId() {
		return getXri();
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getId();
	}


	/* (non-Javadoc)
	 * @see deus.model.common.user.id.UserId#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}


	/* (non-Javadoc)
	 * @see deus.model.common.user.id.UserId#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}

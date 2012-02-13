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
package deus.model.common.user;


// TODO: what if userFullName changes??? or gender??? (unknown -> male/female)

/**
 * The Class UserMetadata.
 */
public class UserMetadata {

	/** The user full name. */
	private String userFullName;

	/** The gender. */
	private Gender gender;


	/**
	 * Instantiates a new user metadata.
	 */
	public UserMetadata() {
		userFullName = "";
		gender = Gender.unknown;
	}


	/**
	 * Instantiates a new user metadata.
	 * 
	 * @param userFullName
	 *            the user full name
	 * @param gender
	 *            the gender
	 */
	public UserMetadata(String userFullName, Gender gender) {
		super();
		this.userFullName = userFullName;
		this.gender = gender;
	}


	/**
	 * Gets the full name.
	 * 
	 * @return the full name
	 */
	public String getFullName() {
		return userFullName;
	}


	/**
	 * Sets the full name.
	 * 
	 * @param userFullName
	 *            the new full name
	 */
	public void setFullName(String userFullName) {
		this.userFullName = userFullName;
	}


	/**
	 * Gets the gender.
	 * 
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}


	/**
	 * Sets the gender.
	 * 
	 * @param gender
	 *            the new gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "full name: " + userFullName;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((userFullName == null) ? 0 : userFullName.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserMetadata other = (UserMetadata) obj;
		if (gender == null) {
			if (other.gender != null)
				return false;
		}
		else if (!gender.equals(other.gender))
			return false;
		if (userFullName == null) {
			if (other.userFullName != null)
				return false;
		}
		else if (!userFullName.equals(other.userFullName))
			return false;
		return true;
	}

}

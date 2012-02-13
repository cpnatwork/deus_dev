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

import java.net.MalformedURLException;
import java.net.URL;


// TODO: think about only injecting username, etc into constructor, no more setters. Also for Transfer ids

// FIXME: REMOVE HIBERNATE STUFF!
//@SuppressWarnings("serial")
//@Entity
/**
 * The Class UserUrl.
 */
public class UserUrl extends UserId {

	/** The server base url. */
	private URL serverBaseUrl = null;

	/**
	 * Instantiates a new user url.
	 * 
	 * @param username
	 *            the username
	 * @param serverBaseUrl
	 *            the server base url
	 */
	public UserUrl(String username, String serverBaseUrl) {
		super(username);
		try {
			this.serverBaseUrl = new URL(serverBaseUrl);
		}
		catch (MalformedURLException e) {
			throw new RuntimeException("cannot create user URL", e);
		}
	}
	
	/**
	 * Instantiates a new user url.
	 * 
	 * @param username
	 *            the username
	 * @param serverBaseUrl
	 *            the server base url
	 */
	public UserUrl(String username, URL serverBaseUrl) {
		super(username);
		this.serverBaseUrl = serverBaseUrl;
	}

	/* (non-Javadoc)
	 * @see deus.model.common.user.id.UserId#getType()
	 */
	@Override
	public UserIdType getType() {
		return UserIdType.url;
	}

	/**
	 * Gets the server base url.
	 * 
	 * @return the server base url
	 */
	public URL getServerBaseUrl() {
		return serverBaseUrl;
	}


	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public URL getUrl() {
		try {
			return new URL(serverBaseUrl, getUsername());
		}
		catch (MalformedURLException e) {
			throw new RuntimeException("cannot return user URL", e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see deus.model.common.user.id.UserId#getId()
	 */
	@Override
	public String getId() {
		return getUrl().toString();
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serverBaseUrl == null) ? 0 : serverBaseUrl.hashCode());
		result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
		return result;
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
		UserUrl other = (UserUrl) obj;
		if (serverBaseUrl == null) {
			if (other.serverBaseUrl != null)
				return false;
		}
		else if (!serverBaseUrl.equals(other.serverBaseUrl))
			return false;
		if (getUsername() == null) {
			if (other.getUsername() != null)
				return false;
		}
		else if (!getUsername().equals(other.getUsername()))
			return false;
		return true;
	}


}

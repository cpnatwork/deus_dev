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

import java.util.Locale;

import deus.model.dccontent.party.common.EntityTag;

/**
 * The Class Address.
 */
public abstract class Address {

	/** The entity tag. */
	private EntityTag entityTag;

	/** The country. */
	private Locale country;

	/** The region. */
	private String region;

	/** The locality. */
	private String locality; // city

	/** The zip. */
	private String zip;

	/** The extension. */
	private String extension;

	/**
	 * Gets the entity tag.
	 * 
	 * @return the entity tag
	 */
	public EntityTag getEntityTag() {
		return this.entityTag;
	}

	/**
	 * Sets the entity tag.
	 * 
	 * @param entityTag
	 *            the new entity tag
	 */
	public void setEntityTag(final EntityTag entityTag) {
		this.entityTag = entityTag;
	}

	/**
	 * Gets the country.
	 * 
	 * @return the country
	 */
	public Locale getCountry() {
		return this.country;
	}

	/**
	 * Sets the country.
	 * 
	 * @param country
	 *            the new country
	 */
	public void setCountry(final Locale country) {
		this.country = country;
	}

	/**
	 * Gets the region.
	 * 
	 * @return the region
	 */
	public String getRegion() {
		return this.region;
	}

	/**
	 * Sets the region.
	 * 
	 * @param region
	 *            the new region
	 */
	public void setRegion(final String region) {
		this.region = region;
	}

	/**
	 * Gets the locality.
	 * 
	 * @return the locality
	 */
	public String getLocality() {
		return this.locality;
	}

	/**
	 * Sets the locality.
	 * 
	 * @param locality
	 *            the new locality
	 */
	public void setLocality(final String locality) {
		this.locality = locality;
	}

	/**
	 * Gets the zip.
	 * 
	 * @return the zip
	 */
	public String getZip() {
		return this.zip;
	}

	/**
	 * Sets the zip.
	 * 
	 * @param zip
	 *            the new zip
	 */
	public void setZip(final String zip) {
		this.zip = zip;
	}

	/**
	 * Gets the extension.
	 * 
	 * @return the extension
	 */
	public String getExtension() {
		return this.extension;
	}

	/**
	 * Sets the extension.
	 * 
	 * @param extension
	 *            the new extension
	 */
	public void setExtension(final String extension) {
		this.extension = extension;
	}

}

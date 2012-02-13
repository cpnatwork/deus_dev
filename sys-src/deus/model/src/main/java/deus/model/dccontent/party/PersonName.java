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

import java.util.List;

/**
 * The Class PersonName.
 */
public class PersonName {

	/** The first. */
	private String first;

	/** The last. */
	private String last;

	/** The additional. */
	private List<String> additional;

	/** The prefixes. */
	private List<String> prefixes;

	/** The suffixes. */
	private List<String> suffixes;

	/** The maiden. */
	private String maiden;

	/** The nick. */
	private String nick;

	/**
	 * Gets the first.
	 * 
	 * @return the first
	 */
	public String getFirst() {
		return this.first;
	}

	/**
	 * Sets the first.
	 * 
	 * @param first
	 *            the new first
	 */
	public void setFirst(final String first) {
		this.first = first;
	}

	/**
	 * Gets the last.
	 * 
	 * @return the last
	 */
	public String getLast() {
		return this.last;
	}

	/**
	 * Sets the last.
	 * 
	 * @param last
	 *            the new last
	 */
	public void setLast(final String last) {
		this.last = last;
	}

	/**
	 * Gets the additional.
	 * 
	 * @return the additional
	 */
	public List<String> getAdditional() {
		return this.additional;
	}

	/**
	 * Sets the additional.
	 * 
	 * @param additional
	 *            the new additional
	 */
	public void setAdditional(final List<String> additional) {
		this.additional = additional;
	}

	/**
	 * Gets the prefixes.
	 * 
	 * @return the prefixes
	 */
	public List<String> getPrefixes() {
		return this.prefixes;
	}

	/**
	 * Sets the prefixes.
	 * 
	 * @param prefixes
	 *            the new prefixes
	 */
	public void setPrefixes(final List<String> prefixes) {
		this.prefixes = prefixes;
	}

	/**
	 * Gets the suffixes.
	 * 
	 * @return the suffixes
	 */
	public List<String> getSuffixes() {
		return this.suffixes;
	}

	/**
	 * Sets the suffixes.
	 * 
	 * @param suffixes
	 *            the new suffixes
	 */
	public void setSuffixes(final List<String> suffixes) {
		this.suffixes = suffixes;
	}

	/**
	 * Gets the maiden.
	 * 
	 * @return the maiden
	 */
	public String getMaiden() {
		return this.maiden;
	}

	/**
	 * Sets the maiden.
	 * 
	 * @param maiden
	 *            the new maiden
	 */
	public void setMaiden(final String maiden) {
		this.maiden = maiden;
	}

	/**
	 * Gets the nick.
	 * 
	 * @return the nick
	 */
	public String getNick() {
		return this.nick;
	}

	/**
	 * Sets the nick.
	 * 
	 * @param nick
	 *            the new nick
	 */
	public void setNick(final String nick) {
		this.nick = nick;
	}

}

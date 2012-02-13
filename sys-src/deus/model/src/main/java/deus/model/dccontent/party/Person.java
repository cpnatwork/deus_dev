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

import java.awt.Image;
import java.util.List;

import javax.sound.sampled.Clip;

import deus.model.common.user.Gender;
import deus.model.dccontent.party.common.DatePlace;

/**
 * The Class Person.
 */
public class Person extends Party {

	/** The name. */
	protected PersonName name;

	/** The full name. */
	protected String fullName;

	/** The gender. */
	protected Gender gender;

	/** The birth. */
	protected DatePlace birth;

	/** The death. */
	protected DatePlace death;

	/** The photo. */
	protected Image photo;

	/** The note. */
	protected String note;
	// TODO: is it correct to use Clip here?
	/** The sound. */
	protected Clip sound;

	/** The languages. */
	protected List<Language> languages;

	/** The phones. */
	protected List<? extends Phone> phones;

	/** The emails. */
	protected List<? extends Email> emails;

	/** The web presences. */
	protected List<? extends WebPresence> webPresences;

	/** The im accounts. */
	protected List<? extends ImAccount> imAccounts;

	/** The addresses. */
	protected List<? extends Address> addresses;

	/** The occupations. */
	protected List<? extends Occupation> occupations;

	/** The related persons. */
	protected List<? extends RelatedPerson> relatedPersons;

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public PersonName getName() {
		return this.name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(final PersonName name) {
		this.name = name;
	}

	/**
	 * Gets the full name.
	 * 
	 * @return the full name
	 */
	public String getFullName() {
		return this.fullName;
	}

	/**
	 * Sets the full name.
	 * 
	 * @param fullName
	 *            the new full name
	 */
	public void setFullName(final String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Gets the gender.
	 * 
	 * @return the gender
	 */
	public Gender getGender() {
		return this.gender;
	}

	/**
	 * Sets the gender.
	 * 
	 * @param gender
	 *            the new gender
	 */
	public void setGender(final Gender gender) {
		this.gender = gender;
	}

	/**
	 * Gets the birth.
	 * 
	 * @return the birth
	 */
	public DatePlace getBirth() {
		return this.birth;
	}

	/**
	 * Sets the birth.
	 * 
	 * @param birth
	 *            the new birth
	 */
	public void setBirth(final DatePlace birth) {
		this.birth = birth;
	}

	/**
	 * Gets the death.
	 * 
	 * @return the death
	 */
	public DatePlace getDeath() {
		return this.death;
	}

	/**
	 * Sets the death.
	 * 
	 * @param death
	 *            the new death
	 */
	public void setDeath(final DatePlace death) {
		this.death = death;
	}

	/**
	 * Gets the photo.
	 * 
	 * @return the photo
	 */
	public Image getPhoto() {
		return this.photo;
	}

	/**
	 * Sets the photo.
	 * 
	 * @param photo
	 *            the new photo
	 */
	public void setPhoto(final Image photo) {
		this.photo = photo;
	}

	/**
	 * Gets the note.
	 * 
	 * @return the note
	 */
	public String getNote() {
		return this.note;
	}

	/**
	 * Sets the note.
	 * 
	 * @param note
	 *            the new note
	 */
	public void setNote(final String note) {
		this.note = note;
	}

	/**
	 * Gets the sound.
	 * 
	 * @return the sound
	 */
	public Clip getSound() {
		return this.sound;
	}

	/**
	 * Sets the sound.
	 * 
	 * @param sound
	 *            the new sound
	 */
	public void setSound(final Clip sound) {
		this.sound = sound;
	}

	/**
	 * Gets the languages.
	 * 
	 * @return the languages
	 */
	public List<Language> getLanguages() {
		return this.languages;
	}

	/**
	 * Sets the languages.
	 * 
	 * @param languages
	 *            the new languages
	 */
	public void setLanguages(final List<Language> languages) {
		this.languages = languages;
	}

	/**
	 * Gets the phones.
	 * 
	 * @return the phones
	 */
	public List<? extends Phone> getPhones() {
		return this.phones;
	}

	/**
	 * Sets the phones.
	 * 
	 * @param phones
	 *            the new phones
	 */
	public void setPhones(final List<? extends Phone> phones) {
		this.phones = phones;
	}

	/**
	 * Gets the emails.
	 * 
	 * @return the emails
	 */
	public List<? extends Email> getEmails() {
		return this.emails;
	}

	/**
	 * Sets the emails.
	 * 
	 * @param emails
	 *            the new emails
	 */
	public void setEmails(final List<Email> emails) {
		this.emails = emails;
	}

	/**
	 * Gets the web presences.
	 * 
	 * @return the web presences
	 */
	public List<? extends WebPresence> getWebPresences() {
		return this.webPresences;
	}

	/**
	 * Sets the web presences.
	 * 
	 * @param webPresences
	 *            the new web presences
	 */
	public void setWebPresences(final List<WebPresence> webPresences) {
		this.webPresences = webPresences;
	}

	/**
	 * Gets the im accounts.
	 * 
	 * @return the im accounts
	 */
	public List<? extends ImAccount> getImAccounts() {
		return this.imAccounts;
	}

	/**
	 * Sets the im accounts.
	 * 
	 * @param imAccounts
	 *            the new im accounts
	 */
	public void setImAccounts(final List<ImAccount> imAccounts) {
		this.imAccounts = imAccounts;
	}

	/**
	 * Gets the addresses.
	 * 
	 * @return the addresses
	 */
	public List<? extends Address> getAddresses() {
		return this.addresses;
	}

	/**
	 * Sets the addresses.
	 * 
	 * @param addresses
	 *            the new addresses
	 */
	public void setAddresses(final List<Address> addresses) {
		this.addresses = addresses;
	}

	/**
	 * Gets the occupations.
	 * 
	 * @return the occupations
	 */
	public List<? extends Occupation> getOccupations() {
		return this.occupations;
	}

	/**
	 * Sets the occupations.
	 * 
	 * @param occupations
	 *            the new occupations
	 */
	public void setOccupations(final List<Occupation> occupations) {
		this.occupations = occupations;
	}

	/**
	 * Gets the related persons.
	 * 
	 * @return the related persons
	 */
	public List<? extends RelatedPerson> getRelatedPersons() {
		return this.relatedPersons;
	}

	/**
	 * Sets the related persons.
	 * 
	 * @param relatedPersons
	 *            the new related persons
	 */
	public void setRelatedPersons(final List<RelatedPerson> relatedPersons) {
		this.relatedPersons = relatedPersons;
	}

}

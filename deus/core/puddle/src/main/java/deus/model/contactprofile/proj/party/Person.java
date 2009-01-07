package deus.model.contactprofile.proj.party;

import java.awt.Image;
import java.util.List;

import javax.sound.sampled.Clip;

import deus.model.contactprofile.proj.party.common.DatePlace;

public class Person extends Party {

	protected PersonName name;
	protected String fullName;	
	
	protected Gender gender;
	
	protected DatePlace birth;
	protected DatePlace death;
	
	protected Image photo;
	
	protected String note;
	// TODO: is it correct to use Clip here?
	protected Clip sound;
	

	protected List<Language> languages;
	
	protected List<? extends Phone> phones;
	protected List<? extends Email> emails;
	protected List<? extends WebPresence> webPresences;
	protected List<? extends ImAccount> imAccounts;
	
	protected List<? extends Address> addresses;
	
	protected List<? extends Occupation> occupations;
	
	protected List<? extends RelatedPerson> relatedPersons;

	public PersonName getName() {
		return name;
	}

	public void setName(PersonName name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public DatePlace getBirth() {
		return birth;
	}

	public void setBirth(DatePlace birth) {
		this.birth = birth;
	}

	public DatePlace getDeath() {
		return death;
	}

	public void setDeath(DatePlace death) {
		this.death = death;
	}

	public Image getPhoto() {
		return photo;
	}

	public void setPhoto(Image photo) {
		this.photo = photo;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Clip getSound() {
		return sound;
	}

	public void setSound(Clip sound) {
		this.sound = sound;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public List<? extends Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<? extends Phone> phones) {
		this.phones = phones;
	}

	public List<? extends Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public List<? extends WebPresence> getWebPresences() {
		return webPresences;
	}

	public void setWebPresences(List<WebPresence> webPresences) {
		this.webPresences = webPresences;
	}

	public List<? extends ImAccount> getImAccounts() {
		return imAccounts;
	}

	public void setImAccounts(List<ImAccount> imAccounts) {
		this.imAccounts = imAccounts;
	}

	public List<? extends Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<? extends Occupation> getOccupations() {
		return occupations;
	}

	public void setOccupations(List<Occupation> occupations) {
		this.occupations = occupations;
	}

	public List<? extends RelatedPerson> getRelatedPersons() {
		return relatedPersons;
	}

	public void setRelatedPersons(List<RelatedPerson> relatedPersons) {
		this.relatedPersons = relatedPersons;
	}
	
}

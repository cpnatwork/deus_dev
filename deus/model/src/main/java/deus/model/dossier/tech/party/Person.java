package deus.model.dossier.tech.party;

import java.util.List;

public class Person extends deus.model.dossier.proj.party.Person {

	@SuppressWarnings("unchecked")
	public List<Phone> getPhones() {
		return (List<Phone>) phones;
	}

	@SuppressWarnings("unchecked")
	public List<Email> getEmails() {
		return (List<Email>) emails;
	}

	@SuppressWarnings("unchecked")
	public List<WebPresence> getWebPresences() {
		return (List<WebPresence>) webPresences;
	}

	@SuppressWarnings("unchecked")
	public List<ImAccount> getImAccounts() {
		return (List<ImAccount>) imAccounts;
	}

	@SuppressWarnings("unchecked")
	public List<Address> getAddresses() {
		return (List<Address>) addresses;
	}

	@SuppressWarnings("unchecked")
	public List<Occupation> getOccupations() {
		return (List<Occupation>) occupations;
	}

	@SuppressWarnings("unchecked")
	public List<RelatedPerson> getRelatedPersons() {
		return (List<RelatedPerson>) relatedPersons;
	}

}

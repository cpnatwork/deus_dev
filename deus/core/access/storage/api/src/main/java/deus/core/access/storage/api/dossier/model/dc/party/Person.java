package deus.core.access.storage.api.dossier.model.dc.party;

import java.util.List;

import deus.model.dossier.proj.party.Email;
import deus.model.dossier.proj.party.ImAccount;
import deus.model.dossier.proj.party.Occupation;
import deus.model.dossier.proj.party.Phone;
import deus.model.dossier.proj.party.RelatedPerson;
import deus.model.dossier.proj.party.WebPresence;

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
	public List<AddressPO> getAddresses() {
		return (List<AddressPO>) addresses;
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

package dacus.domain.party.person;

import java.awt.Image;
import java.util.List;

import javax.sound.sampled.Clip;

import dacus.storage.common.DatePlace;
import dacus.storage.party.Party;
import dacus.storage.party.address.Address;
import dacus.storage.party.email.Email;
import dacus.storage.party.im.ImAccount;
import dacus.storage.party.language.Language;
import dacus.storage.party.person.occupation.Occupation;
import dacus.storage.party.person.related.RelatedPerson;
import dacus.storage.party.phone.Phone;
import dacus.storage.party.web.WebPresence;

public class Person extends Party {

	private PersonName name;
	private String fullName;	
	
	private Gender gender;
	
	private DatePlace birth;
	private DatePlace death;
	
	private Image photo;
	
	private String note;
	// TODO: is it correct to use Clip here?
	private Clip sound;
	

	private List<Language> languages;
	
	private List<Phone> phones;
	private List<Email> emails;
	private List<WebPresence> webPresences;
	private List<ImAccount> imAccounts;
	
	private List<Address> addresses;
	
	private List<Occupation> occupations;
	
	private List<RelatedPerson> relatedPersons;
	
	
	
}

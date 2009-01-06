package dacus.domain.party.person;

import java.awt.Image;
import java.util.List;

import javax.sound.sampled.Clip;

import dacus.domain.party.common.DatePlace;
import dacus.domain.party.Party;
import dacus.domain.party.address.Address;
import dacus.domain.party.email.Email;
import dacus.domain.party.im.ImAccount;
import dacus.domain.party.language.Language;
import dacus.domain.party.person.occupation.Occupation;
import dacus.domain.party.person.related.RelatedPerson;
import dacus.domain.party.phone.Phone;
import dacus.domain.party.web.WebPresence;

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

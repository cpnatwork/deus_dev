package dacus.domain.party;

import java.awt.Image;
import java.util.List;

import javax.sound.sampled.Clip;

import dacus.domain.party.common.DatePlace;

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

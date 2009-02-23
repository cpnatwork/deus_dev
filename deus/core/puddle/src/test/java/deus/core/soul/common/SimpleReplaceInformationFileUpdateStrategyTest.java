package deus.core.soul.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import deus.model.dossier.DigitalCard;
import deus.model.dossier.InformationFile;
import deus.model.dossier.MyPartyInformationDC;
import deus.model.dossier.PartyInformationDC;
import deus.model.dossier.proj.party.Gender;
import deus.model.dossier.proj.party.Party;
import deus.model.dossier.proj.party.Person;
import deus.model.pie.PersonalInformationFile;
import deus.model.user.id.UserId;
import deus.model.user.id.UserUrl;

public class SimpleReplaceInformationFileUpdateStrategyTest {

	private SimpleReplaceInformationFileUpdateStrategy strategy;

	private InformationFile informationFile;

	private Set<DigitalCard> digitalCards;

	private PartyInformationDC dc;


	@Before
	public void setUp() throws Exception {
		UserId userId = new UserUrl("alice", "deus.org");
		
		strategy = new SimpleReplaceInformationFileUpdateStrategy();

		digitalCards = new HashSet<DigitalCard>();
		informationFile = new PersonalInformationFile(userId, digitalCards);

		dc = new MyPartyInformationDC(new UserUrl("alice", "deus.org"));

		Party party = new Person();
		party.setId(userId);

		dc.setPartyInformation(party);
	}


	@Test
	public void testAppend() {
		assertTrue(informationFile.getDigitalCards().isEmpty());
		strategy.update(informationFile, dc);
		assertEquals(1, informationFile.getDigitalCards().size());
		assertEquals(dc, informationFile.getDigitalCards().iterator().next());
	}


	@Test
	public void testReplace() {
		// add normal DC
		informationFile.getDigitalCards().add(dc);

		PartyInformationDC updatedDc = new MyPartyInformationDC(new UserUrl("alice", "deus.org"));

		Person person = new Person();
		person.setId(new UserUrl("alice", "deus.org"));
		person.setGender(Gender.male);
		person.setFullName("alices full name");

		updatedDc.setPartyInformation(person);


		assertEquals(1, informationFile.getDigitalCards().size());
		// add updated DC
		strategy.update(informationFile, updatedDc);
		assertEquals(1, informationFile.getDigitalCards().size());
		assertEquals(updatedDc, informationFile.getDigitalCards().iterator().next());
		DigitalCard dcOutOfIf = informationFile.getDigitalCards().iterator().next();
		Person personOutOfIf = (Person) ((PartyInformationDC) dcOutOfIf).getPartyInformation();
		assertEquals(Gender.male, personOutOfIf.getGender());
		assertEquals("alices full name", personOutOfIf.getFullName());
	}

}

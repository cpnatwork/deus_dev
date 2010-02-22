package deus.core.soul.pifgoverning;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import deus.model.common.dossier.DigitalCard;
import deus.model.common.dossier.InformationFile;
import deus.model.common.user.id.UserId;
import deus.model.common.user.id.UserUrl;
import deus.model.dccontent.MyPartyInformationDC;
import deus.model.dccontent.PartyInformationDC;
import deus.model.dccontent.party.Party;
import deus.model.dccontent.party.Person;
import deus.model.pifgoverning.PersonalInformationFile;

public class SimpleAppendAssimilationStrategyTest {

	private AssimilationStrategy strategy;

	private InformationFile informationFile;

	private Set<DigitalCard> digitalCards;

	private PartyInformationDC dc;


	@Before
	public void setUp() throws Exception {
		UserId userId = new UserUrl("alice", "http://www.deus.org");
		
		strategy = new SimpleAppendAssimilationStrategy();

		digitalCards = new HashSet<DigitalCard>();
		informationFile = new PersonalInformationFile(digitalCards);

		dc = new MyPartyInformationDC(userId);

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


	/*@Test
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
	}*/

}

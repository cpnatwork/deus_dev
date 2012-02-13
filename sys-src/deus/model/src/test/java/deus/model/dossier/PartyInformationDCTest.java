package deus.model.dossier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import deus.model.common.dossier.DigitalCardId;
import deus.model.common.user.id.UserUrl;
import deus.model.dccontent.PartyInformationDC;
import deus.model.dccontent.party.Person;

public class PartyInformationDCTest {

	private PartyInformationDC dc;

	private Person person;


	@Before
	public void setUp() throws Exception {
		dc = new PartyInformationDC(new DigitalCardId(
				new UserUrl("higgins", "http://www.deus.org"),
				new UserUrl("alice", "http://www.deus.org"),
				"party information from Higgins about Alice"));

		person = new Person();
		person.setId(new UserUrl("alice", "http://www.deus.org"));
		dc.setPartyInformation(person);
	}


	@Test
	public void testGetPartyInformation() {
		assertEquals(person, dc.getPartyInformation());
	}


	@Test
	public void testSetPartyInformation() {
		try {
			Person otherPerson = new Person();
			otherPerson.setId(new UserUrl("another alice", "http://www.deus.org"));
			dc.setPartyInformation(otherPerson);
			fail("could set party information with different ID than the one of the digital card");
		}
		catch (IllegalArgumentException e) {
		}
	}

}

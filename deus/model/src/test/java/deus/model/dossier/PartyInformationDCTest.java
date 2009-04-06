package deus.model.dossier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import deus.model.dc.DigitalCardId;
import deus.model.dc.PartyInformationDC;
import deus.model.party.Person;
import deus.model.user.id.UserUrl;

public class PartyInformationDCTest {

	private PartyInformationDC dc;

	private Person person;


	@Before
	public void setUp() throws Exception {
		dc = new PartyInformationDC(new DigitalCardId(
				new UserUrl("higgins", "deus.org"),
				new UserUrl("alice", "deus.org"),
				"party information from Higgins about Alice"));

		person = new Person();
		person.setId(new UserUrl("alice", "deus.org"));
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
			otherPerson.setId(new UserUrl("another alice", "deus.org"));
			dc.setPartyInformation(otherPerson);
			fail("could set party information with different ID than the one of the digital card");
		}
		catch (IllegalArgumentException e) {
		}
	}

}

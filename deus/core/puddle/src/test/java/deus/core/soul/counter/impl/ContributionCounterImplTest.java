package deus.core.soul.counter.impl;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import deus.core.soul.contribution.hub.ContributionHubExportedToPeer;
import deus.core.soul.contribution.hub.impl.ContributionHubImpl;
import deus.model.dossier.DigitalCard;
import deus.model.dossier.PartyInformationDC;
import deus.model.user.id.UserUrl;

public class ContributionCounterImplTest {

	private ContributionHubExportedToPeer counter;
	
	private DigitalCard digitalCard;
	
	@Before
	public void setUp() throws Exception {
		counter = new ContributionHubImpl(new UserUrl("alice", "deus.org"), null, null);
		
		digitalCard = new PartyInformationDC(new UserUrl("higgins", "deus.org"), new UserUrl("alice", "deus.org"), "higgins about alice");
	}


	@Test
	public void testContributeWithBadContributorId() {
		try {
			counter.contributeOther(digitalCard, new UserUrl("bob", "deus.org"));
			fail("contribution with different contributor id than in the DC is possible");
		}
		catch(IllegalArgumentException e) {
			assertEquals("ID of the contributor does not match the id in the digital card!", e.getMessage());
		}
	}
	
}

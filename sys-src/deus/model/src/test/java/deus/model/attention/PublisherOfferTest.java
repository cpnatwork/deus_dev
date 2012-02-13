package deus.model.attention;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import deus.model.common.user.UserMetadata;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.id.UserUrl;
import deus.model.hci.attention.BinaryDecisionToMake;
import deus.model.hci.attention.publication.connection.establish.pubinit.PublisherOffer;

public class PublisherOfferTest {

	BinaryDecisionToMake dec;
	
	@Before
	public void setUp() throws Exception {
		dec = new PublisherOffer(new PublisherId(new UserUrl("alice", "http://www.deus.org")), new UserMetadata());
	}


	@Test
	public void testSetDecisionPositive() {
		assertFalse(dec.isDecisionMade());
		dec.setDecisionPositive();
		assertTrue(dec.isDecisionMade());
		assertTrue(dec.isDecisionPositive());
		assertFalse(dec.isDecisionNegative());
	}

	
	@Test
	public void testSetDecisionNegative() {
		assertFalse(dec.isDecisionMade());
		dec.setDecisionNegative();
		assertTrue(dec.isDecisionMade());
		assertTrue(dec.isDecisionNegative());
		assertFalse(dec.isDecisionPositive());
	}
	
	
	@Test
	public void testException() {
		assertFalse(dec.isDecisionMade());
		try {
			dec.isDecisionPositive();
			fail("exception not thrown");
		}
		catch(IllegalStateException e) {}
		try {
			dec.isDecisionNegative();
			fail("exception not thrown");
		}
		catch(IllegalStateException e) {}
	}
}

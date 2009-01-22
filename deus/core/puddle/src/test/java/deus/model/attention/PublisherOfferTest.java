package deus.model.attention;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import deus.model.sub.PublisherMetadata;

public class PublisherOfferTest {

	BinaryDecisionToMake dec;
	
	@Before
	public void setUp() throws Exception {
		dec = new PublisherOffer(new PublisherMetadata());
	}


	@Test
	public void testSetDecisionPositive() {
		assertFalse(dec.isProcessed());
		dec.setDecisionPositive();
		assertTrue(dec.isProcessed());
		assertTrue(dec.isDecisionPositive());
		assertFalse(dec.isDecisionNegative());
	}

	
	@Test
	public void testSetDecisionNegative() {
		assertFalse(dec.isProcessed());
		dec.setDecisionNegative();
		assertTrue(dec.isProcessed());
		assertTrue(dec.isDecisionNegative());
		assertFalse(dec.isDecisionPositive());
	}
	
	
	@Test
	public void testException() {
		assertFalse(dec.isProcessed());
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

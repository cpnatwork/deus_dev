package deus.model.user.id;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import deus.model.user.id.transportid.IcqTransportId;
import deus.model.user.id.transportid.XmppTransportId;

public class UserUrlTest {

	private UserUrl userUrl;
	
	private XmppTransportId xmppTransportId;
	
	private IcqTransportId icqTransportId;
	
	
	@Before
	public void setUp() {
		userUrl = new UserUrl();
		userUrl.setUsername("username");
		userUrl.setServerBaseUrl("server.base.path");
		
		xmppTransportId = new XmppTransportId();
		xmppTransportId.setXmppServer("xmppserver");
		xmppTransportId.setXmppUsername("xmppUsername");
		userUrl.addTransportId(xmppTransportId);
	}
	
	@Test
	public void testGetType() {
		assertEquals(UserIdType.url, userUrl.getType());
	}


	@Test
	public void testAddAnotherTransportId() {
		try {
			userUrl.addTransportId(xmppTransportId);
			fail("it was able to add a second xmpp transport id");
		}
		catch(RuntimeException e) {}

	}
	
	
	@Test
	public void testGetTransportId() {
		XmppTransportId xmppTransportId = userUrl.getTransportId(XmppTransportId.class);
		assertEquals(this.xmppTransportId, xmppTransportId);
		
		icqTransportId = new IcqTransportId();
		userUrl.addTransportId(icqTransportId);
		
		IcqTransportId icqTransportId = userUrl.getTransportId(IcqTransportId.class);
		assertEquals(this.icqTransportId, icqTransportId);
	}
	
	@Test
	public void testRetrieveUnavailableTransportId() {
		try {
			userUrl.getTransportId(IcqTransportId.class);
			fail("can retrieve unavailable transport id ?!?");
		}
		catch(RuntimeException e) {}		
	}
	
	
	@Test
	public void testGetter() {
		assertEquals("username", userUrl.getUsername());
		assertEquals("server.base.path", userUrl.getServerBaseUrl());
	}

}

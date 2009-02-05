package deus.core.access.transport.core.soul.protocolregistry.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.access.transport.core.messages.TransportMessage;
import deus.core.access.transport.core.soul.protocol.MessageSender;
import deus.core.access.transport.core.soul.protocol.TransportId;
import deus.core.access.transport.core.soul.protocol.TransportIdUserIdMapper;
import deus.core.access.transport.core.soul.protocolregistry.TransportProtocolRegistry;
import deus.core.access.transport.plugins.testTP.protocol.TestTransportId;
import deus.core.access.transport.plugins.testTP.protocol.TestTransportProtocol;
import deus.model.user.id.UserId;
import deus.model.user.id.UserUrl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml", "/deus/core/transport/test.xml" })
public class TransportProtocolRegistryImplTest {
	
	private TestTransportProtocol tp;


	@Autowired
	private TransportProtocolRegistry registry;

	private String testProtocolId;

	@Before
	public void setUp() throws Exception {
		tp = new TestTransportProtocol();
		tp.setLoginEventCallback(null); // we don't need login for this test
		tp.setRegistrationEventCallback(null); // we don't need registration for this test
		
		TransportIdUserIdMapper mapper = new TransportIdUserIdMapper() {

			@Override
			public TransportId map(UserId userId) {
				return new TestTransportId(userId.toString());
			}


			@Override
			public UserId map(TransportId transportId) {
				return new UserUrl(((TestTransportId) transportId).getUsername(), "deus.org");
			}

		};
		
		tp.setTransportIdUserIdMapper(mapper);
		
		tp.setMessageSender(new MessageSender() {

			@Override
			public void send(TransportMessage command) {
				System.out.println("sending");
			}

		});
		
		testProtocolId = tp.getId();
	}


	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testRegisterTransportProtocol() {
		assertTrue(registry.getAllRegisteredTransportProtocolIds().isEmpty());
		assertNull(registry.getRegisteredTransportProtocol(testProtocolId));
		
		registry.registerTransportProtocol(tp);
		
		assertTrue(registry.getAllRegisteredTransportProtocolIds().contains(testProtocolId));
		assertEquals(tp, registry.getRegisteredTransportProtocol(testProtocolId));
		
		registry.unregisterTransportProtocol(testProtocolId);
		
		assertTrue(registry.getAllRegisteredTransportProtocolIds().isEmpty());
		assertNull(registry.getRegisteredTransportProtocol(testProtocolId));
		
		try {
			registry.unregisterTransportProtocol("haha");
			fail("shouldn't be able to unregister non-existing TP");
		}
		catch(IllegalArgumentException e) {}
	}

}

package deus.core.transport.core.protocolregistry.impl;

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

import deus.core.transport.core.protocol.MessageSender;
import deus.core.transport.core.protocol.TransportId;
import deus.core.transport.core.protocol.TransportIdUserIdMapper;
import deus.core.transport.core.protocolregistry.TransportProtocolRegistry;
import deus.core.transport.messages.TransportMessage;
import deus.model.user.id.UserId;
import deus.model.user.id.UserUrl;
import deus.transport.testTP.protocol.TestTransportId;
import deus.transport.testTP.protocol.TestTransportProtocol;

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

package deus.core.transport.protocolregistry.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.transport.message.TransportMessage;
import deus.core.transport.message.sender.MessageSender;
import deus.core.transport.protocol.TransportId;
import deus.core.transport.protocol.TransportIdUserIdMapper;
import deus.core.transport.protocol.TransportProtocol;
import deus.core.transport.protocolregistry.TransportProtocolRegistry;
import deus.model.user.id.UserId;
import deus.model.user.id.UserUrl;
import deus.transport.testTP.protocol.TestTransportId;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml", "/deus/core/transport/test.xml" })
public class TransportProtocolRegistryImplTest {
	
	private TransportProtocol tp;


	@Autowired
	private TransportProtocolRegistry registry;


	@Before
	public void setUp() throws Exception {
		tp = new TransportProtocol();
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
	}


	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testRegisterTransportProtocol() {
		assertTrue(registry.getAllRegisteredTransportProtocolIds().isEmpty());
		assertNull(registry.getRegisteredTransportProtocol("test"));
		
		registry.registerTransportProtocol("test", tp);
		
		assertTrue(registry.getAllRegisteredTransportProtocolIds().contains("test"));
		assertEquals(tp, registry.getRegisteredTransportProtocol("test"));
		
		registry.unregisterTransportProtocol("test");
		
		assertTrue(registry.getAllRegisteredTransportProtocolIds().isEmpty());
		assertNull(registry.getRegisteredTransportProtocol("test"));
		
		try {
			registry.unregisterTransportProtocol("haha");
			fail("shouldn't be able to unregister non-existing TP");
		}
		catch(IllegalArgumentException e) {}
	}

}

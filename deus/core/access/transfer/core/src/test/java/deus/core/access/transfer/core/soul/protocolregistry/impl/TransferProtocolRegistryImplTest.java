package deus.core.access.transfer.core.soul.protocolregistry.impl;

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

import deus.core.access.transfer.core.messages.TransferMessage;
import deus.core.access.transfer.core.soul.mapper.UserIdMapper;
import deus.core.access.transfer.core.soul.protocol.MessageSender;
import deus.core.access.transfer.core.soul.protocol.TransferId;
import deus.core.access.transfer.core.soul.protocolregistry.TransferProtocolRegistry;
import deus.core.access.transfer.plugins.testTP.protocol.TestTransportId;
import deus.core.access.transfer.plugins.testTP.protocol.TestTransportProtocol;
import deus.model.user.id.UserId;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml", "/deus/core/access/transport/core/test.xml" })
public class TransferProtocolRegistryImplTest {
	
	private TestTransportProtocol tp;


	@Autowired
	private TransferProtocolRegistry registry;

	private String testProtocolId;

	@Before
	public void setUp() throws Exception {
		tp = new TestTransportProtocol();
		tp.setLoginEventCallback(null); // we don't need login for this test
		tp.setRegistrationEventCallback(null); // we don't need registration for this test
				
		UserIdMapper userIdMapper = new UserIdMapper() {

			@Override
			public TransferId resolveLocal(UserId userId) {
				return new TestTransportId(userId.toString());
			}

			@Override
			public TransferId resolveRemote(UserId userId) {
				return new TestTransportId(userId.toString());
			}

		};
		tp.setUserIdMapper(userIdMapper);
		
		
		
		tp.setMessageSender(new MessageSender() {

			@Override
			public void send(@SuppressWarnings("unused") TransferMessage message) {
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

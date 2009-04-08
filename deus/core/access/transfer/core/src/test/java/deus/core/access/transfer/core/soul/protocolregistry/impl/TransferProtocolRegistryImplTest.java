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

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.core.access.transfer.common.protocol.TransferId;
import deus.core.access.transfer.common.protocol.TransferProtocolImpl;
import deus.core.access.transfer.common.protocol.mapper.UserIdMapper;
import deus.core.access.transfer.common.protocol.messagesender.MessageSender;
import deus.core.access.transfer.core.soul.protocolregistry.QueriableTransferProtocolRegistry;
import deus.core.access.transfer.plugins.testTP.protocol.TestTransferId;
import deus.model.common.user.id.UserId;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml", "/deus/core/access/transfer/core/test.xml" })
public class TransferProtocolRegistryImplTest {
	
	private TransferProtocolImpl tp;


	@Autowired
	private QueriableTransferProtocolRegistry registry;

	private String testProtocolId;

	@Before
	public void setUp() throws Exception {
		tp = new TransferProtocolImpl();
		tp.setLoginEventCallback(null); // we don't need login for this test
		tp.setRegistrationEventCallback(null); // we don't need registration for this test
				
		UserIdMapper userIdMapper = new UserIdMapper() {

			@Override
			public TransferId resolveLocal(UserId userId) {
				return new TestTransferId(userId.toString());
			}

			@Override
			public TransferId resolveRemote(UserId userId) {
				return new TestTransferId(userId.toString());
			}

		};
		tp.setUserIdMapper(userIdMapper);
		
		
		
		tp.setMessageSender(new MessageSender() {

			@Override
			public void send(@SuppressWarnings("unused") TransferMessage message) {
				System.out.println("sending");
			}

		});
		
		testProtocolId = tp.getProtocolId();
	}


	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testRegisterTransferProtocol() {
		assertTrue(registry.getAllRegisteredTransferProtocolIds().isEmpty());
		assertNull(registry.getRegisteredTransferProtocol(testProtocolId));
		
		registry.registerTransferProtocol(tp);
		
		assertTrue(registry.getAllRegisteredTransferProtocolIds().contains(testProtocolId));
		assertEquals(tp, registry.getRegisteredTransferProtocol(testProtocolId));
		
		registry.unregisterTransferProtocol(testProtocolId);
		
		assertTrue(registry.getAllRegisteredTransferProtocolIds().isEmpty());
		assertNull(registry.getRegisteredTransferProtocol(testProtocolId));
		
		try {
			registry.unregisterTransferProtocol("haha");
			fail("shouldn't be able to unregister non-existing TP");
		}
		catch(IllegalArgumentException e) {}
	}

}

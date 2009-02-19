package deus.core.access.transport.core.sending.command.impl;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import deus.core.access.transport.core.messages.TransportMessage;
import deus.core.access.transport.core.soul.discovery.TransportProtocolDiscoveryStrategy;
import deus.core.access.transport.core.soul.mapper.UserIdMapper;
import deus.core.access.transport.core.soul.protocol.MessageSender;
import deus.core.access.transport.core.soul.protocol.TransportId;
import deus.core.access.transport.core.soul.protocolregistry.ExportedTransportProtocolRegistry;
import deus.core.access.transport.plugins.testTP.protocol.TestTransportId;
import deus.core.access.transport.plugins.testTP.protocol.TestTransportProtocol;
import deus.model.user.id.UserId;
import deus.model.user.id.UserUrl;


public abstract class AbstractCommandSenderTest {

	@Autowired
	protected TransportProtocolDiscoveryStrategy transportProtocolDiscoveryStrategy;
	
	@Autowired
	private ExportedTransportProtocolRegistry transportProtocolRegistry;
	
	
	protected TransportMessage lastSentTransportMessage;
	private TestTransportProtocol tp;
	protected UserIdMapper userIdMapper;

	
	protected UserId subscriberId;	
	protected UserId publisherId;

	private String testTransportProtocolId;


	public AbstractCommandSenderTest() {
		super();
	}


	@Before
	public void setUp() throws Exception {
		subscriberId = new UserUrl("bob", "deus.org");
		publisherId = new UserUrl("alice", "deus.org");

		tp = new TestTransportProtocol();
		tp.setLoginEventCallback(null); // we don't need login for this test
		tp.setRegistrationEventCallback(null); // we don't need registration for this test
		
		userIdMapper = new UserIdMapper() {

			@Override
			public TransportId resolveLocal(UserId userId) {
				return new TestTransportId(userId.toString());
			}

			@Override
			public TransportId resolveRemote(UserId userId) {
				return new TestTransportId(userId.toString());
			}

		};
		tp.setUserIdMapper(userIdMapper);
		
		
		
		tp.setMessageSender(new MessageSender() {

			@Override
			public void send(TransportMessage command) {
				lastSentTransportMessage = command;
			}

		});
		
		testTransportProtocolId = tp.getId();

		transportProtocolRegistry.registerTransportProtocol(tp);
	}


	@After
	public void tearDown() throws Exception {
		transportProtocolRegistry.unregisterTransportProtocol(testTransportProtocolId);
	}


	protected void testEqualsMessage(TransportMessage expected, TransportMessage actual) {
		assertEquals(expected.getClass(), actual.getClass());
		
		assertEquals(expected.getSenderId(), actual.getSenderId());
		assertEquals(expected.getReceiverId(), actual.getReceiverId());

		assertEquals(expected.getSenderTid(), actual.getSenderTid());
		assertEquals(expected.getReceiverTid(), actual.getReceiverTid());
	}


	protected void setTids(TransportMessage expectedMessage, UserId senderId, UserId receiverId) {
		expectedMessage.setSenderId(senderId);
		expectedMessage.setReceiverId(receiverId);
		expectedMessage.setReceiverTid(userIdMapper.resolveRemote(receiverId));
		expectedMessage.setSenderTid(userIdMapper.resolveLocal(senderId));
	}
	
}
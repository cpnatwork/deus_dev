package deus.core.transport.command.sender.impl;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import deus.core.transport.discovery.TransportProtocolDiscoveryStrategy;
import deus.core.transport.message.TransportMessage;
import deus.core.transport.message.sender.MessageSender;
import deus.core.transport.protocol.TransportId;
import deus.core.transport.protocol.TransportIdUserIdMapper;
import deus.core.transport.protocolregistry.TransportProtocolRegistry;
import deus.model.user.id.UserId;
import deus.model.user.id.UserUrl;
import deus.transport.testTP.protocol.TestTransportId;
import deus.transport.testTP.protocol.TestTransportProtocol;


public abstract class AbstractCommandSenderTest {

	@Autowired
	protected TransportProtocolDiscoveryStrategy transportProtocolDiscoveryStrategy;
	
	@Autowired
	private TransportProtocolRegistry transportProtocolRegistry;
	
	
	protected TransportMessage lastSentTransportMessage;
	private TestTransportProtocol tp;
	protected TransportIdUserIdMapper mapper;

	
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
		
		mapper = new TransportIdUserIdMapper() {

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
		assertEquals(expected.getReceiverTid(), actual.getReceiverTid());
		assertEquals(expected.getSenderTid(), actual.getSenderTid());
	}


	protected void setTids(TransportMessage expectedMessage, UserId senderId, UserId receiverId) {
		expectedMessage.setReceiverTid(transportProtocolDiscoveryStrategy.resolveTransportId(testTransportProtocolId, receiverId));
		expectedMessage.setSenderTid(mapper.map(senderId));
	}
	
}
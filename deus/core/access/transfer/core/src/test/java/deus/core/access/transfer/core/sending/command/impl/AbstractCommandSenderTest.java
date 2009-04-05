package deus.core.access.transfer.core.sending.command.impl;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.core.access.transfer.core.soul.discovery.TransferProtocolNegotiationStrategy;
import deus.core.access.transfer.core.soul.mapper.UserIdMapper;
import deus.core.access.transfer.core.soul.protocol.MessageSender;
import deus.core.access.transfer.core.soul.protocol.TransferId;
import deus.core.access.transfer.core.soul.protocolregistry.ExportedTransferProtocolRegistry;
import deus.core.access.transfer.plugins.testTP.protocol.TestTransferId;
import deus.core.access.transfer.plugins.testTP.protocol.TestTransferProtocol;
import deus.model.user.id.UserId;
import deus.model.user.id.UserUrl;


public abstract class AbstractCommandSenderTest {

	@Autowired
	protected TransferProtocolNegotiationStrategy transferProtocolNegotiationStrategy;
	
	@Autowired
	private ExportedTransferProtocolRegistry transferProtocolRegistry;
	
	
	protected TransferMessage lastSentTransferMessage;
	private TestTransferProtocol tp;
	protected UserIdMapper userIdMapper;

	
	protected UserId subscriberId;	
	protected UserId publisherId;

	private String testTransferProtocolId;


	public AbstractCommandSenderTest() {
		super();
	}


	@Before
	public void setUp() throws Exception {
		subscriberId = new UserUrl("bob", "deus.org");
		publisherId = new UserUrl("alice", "deus.org");

		tp = new TestTransferProtocol();
		tp.setLoginEventCallback(null); // we don't need login for this test
		tp.setRegistrationEventCallback(null); // we don't need registration for this test
		
		userIdMapper = new UserIdMapper() {

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
			public void send(TransferMessage command) {
				lastSentTransferMessage = command;
			}

		});
		
		testTransferProtocolId = tp.getId();

		transferProtocolRegistry.registerTransferProtocol(tp);
	}


	@After
	public void tearDown() throws Exception {
		transferProtocolRegistry.unregisterTransferProtocol(testTransferProtocolId);
	}


	protected void testEqualsMessage(TransferMessage expected, TransferMessage actual) {
		assertEquals(expected.getClass(), actual.getClass());
		
		assertEquals(expected.getSenderId(), actual.getSenderId());
		assertEquals(expected.getReceiverId(), actual.getReceiverId());

		assertEquals(expected.getSenderTid(), actual.getSenderTid());
		assertEquals(expected.getReceiverTid(), actual.getReceiverTid());
	}


	protected void setTids(TransferMessage expectedMessage, UserId senderId, UserId receiverId) {
		expectedMessage.setSenderId(senderId);
		expectedMessage.setReceiverId(receiverId);
		expectedMessage.setReceiverTid(userIdMapper.resolveRemote(receiverId));
		expectedMessage.setSenderTid(userIdMapper.resolveLocal(senderId));
	}
	
}
/**************************************************************************
 * DACUS: Distributed Address Card Update System
 * ==============================================
 * Copyright (C) 2008-2012 by 
 *   - Christoph P. Neumann (http://www.chr15t0ph.de)
 *   - Florian Rampp
 **************************************************************************
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 **************************************************************************
 * $Id$
 *************************************************************************/
package deus.core.access.transfer.core.sending.command.impl;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.core.access.transfer.common.protocol.TransferId;
import deus.core.access.transfer.common.protocol.TransferProtocolImpl;
import deus.core.access.transfer.common.protocol.mapper.UserIdMapper;
import deus.core.access.transfer.common.protocol.messagesender.MessageSender;
import deus.core.access.transfer.common.protocolregistry.TransferProtocolRegistry;
import deus.core.access.transfer.core.soul.discovery.TransferProtocolNegotiationStrategy;
import deus.core.access.transfer.plugins.testTP.protocol.TestTransferId;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.common.user.id.UserId;
import deus.model.common.user.id.UserUrl;


/**
 * The Class AbstractCommandSenderTest.
 */
public abstract class AbstractCommandSenderTest {

	/** The transfer protocol negotiation strategy. */
	@Autowired
	protected TransferProtocolNegotiationStrategy transferProtocolNegotiationStrategy;
	
	/** The transfer protocol registry. */
	@Autowired
	private TransferProtocolRegistry transferProtocolRegistry;
	
	
	/** The last sent transfer message. */
	protected TransferMessage lastSentTransferMessage;
	
	/** The tp. */
	private TransferProtocolImpl tp;
	
	/** The user id mapper. */
	protected UserIdMapper userIdMapper;

	
	/** The subscriber id. */
	protected SubscriberId subscriberId;	
	
	/** The publisher id. */
	protected PublisherId publisherId;

	/** The test transfer protocol id. */
	private String testTransferProtocolId;


	/**
	 * Instantiates a new abstract command sender test.
	 */
	public AbstractCommandSenderTest() {
		super();
	}


	/**
	 * Sets the up.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		subscriberId = new SubscriberId(new UserUrl("bob", "http://www.deus.org"));
		publisherId = new PublisherId(new UserUrl("alice", "http://www.deus.org"));

		tp = new TransferProtocolImpl();
		tp.setProtocolId("testProtocol");
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
		
		testTransferProtocolId = tp.getProtocolId();

		transferProtocolRegistry.registerTransferProtocol(tp);
	}


	/**
	 * Tear down.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@After
	public void tearDown() throws Exception {
		transferProtocolRegistry.unregisterTransferProtocol(testTransferProtocolId);
	}


	/**
	 * Test equals message.
	 * 
	 * @param expected
	 *            the expected
	 * @param actual
	 *            the actual
	 */
	protected void testEqualsMessage(TransferMessage expected, TransferMessage actual) {
		assertEquals(expected.getClass(), actual.getClass());
		
		assertEquals(expected.getSenderId(), actual.getSenderId());
		assertEquals(expected.getReceiverId(), actual.getReceiverId());

		assertEquals(expected.getSenderTid(), actual.getSenderTid());
		assertEquals(expected.getReceiverTid(), actual.getReceiverTid());
	}


	/**
	 * Sets the tids.
	 * 
	 * @param expectedMessage
	 *            the expected message
	 * @param senderId
	 *            the sender id
	 * @param receiverId
	 *            the receiver id
	 */
	protected void setTids(TransferMessage expectedMessage, UserId senderId, UserId receiverId) {
		expectedMessage.setSenderId(senderId);
		expectedMessage.setReceiverId(receiverId);
		expectedMessage.setReceiverTid(userIdMapper.resolveRemote(receiverId));
		expectedMessage.setSenderTid(userIdMapper.resolveLocal(senderId));
	}
	
}
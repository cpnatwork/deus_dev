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
package deus.core.access.transfer.core.soul.protocolregistry.impl;

import org.junit.After;
import org.junit.Assert;
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

/**
 * The Class TransferProtocolRegistryImplTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml",
		"/deus/core/access/transfer/core/test.xml" })
public class TransferProtocolRegistryImplTest {

	/** The tp. */
	private TransferProtocolImpl tp;

	/** The registry. */
	@Autowired
	private QueriableTransferProtocolRegistry registry;

	/** The test protocol id. */
	private String testProtocolId;

	/**
	 * Sets the up.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		this.tp = new TransferProtocolImpl();
		this.tp.setLoginEventCallback(null); // we don't need login for this
												// test
		this.tp.setRegistrationEventCallback(null); // we don't need
													// registration for this
													// test

		final UserIdMapper userIdMapper = new UserIdMapper() {

			@Override
			public TransferId resolveLocal(final UserId userId) {
				return new TestTransferId(userId.toString());
			}

			@Override
			public TransferId resolveRemote(final UserId userId) {
				return new TestTransferId(userId.toString());
			}

		};
		this.tp.setUserIdMapper(userIdMapper);

		this.tp.setMessageSender(new MessageSender() {

			@Override
			public void send(
					@SuppressWarnings("unused") final TransferMessage message) {
				System.out.println("sending");
			}

		});

		this.testProtocolId = this.tp.getProtocolId();
	}

	/**
	 * Tear down.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test register transfer protocol.
	 */
	@Test
	public void testRegisterTransferProtocol() {
		Assert.assertTrue(this.registry.getAllRegisteredTransferProtocolIds()
				.isEmpty());
		Assert.assertNull(this.registry
				.getRegisteredTransferProtocol(this.testProtocolId));

		this.registry.registerTransferProtocol(this.tp);

		Assert.assertTrue(this.registry.getAllRegisteredTransferProtocolIds()
				.contains(this.testProtocolId));
		Assert.assertEquals(this.tp, this.registry
				.getRegisteredTransferProtocol(this.testProtocolId));

		this.registry.unregisterTransferProtocol(this.testProtocolId);

		Assert.assertTrue(this.registry.getAllRegisteredTransferProtocolIds()
				.isEmpty());
		Assert.assertNull(this.registry
				.getRegisteredTransferProtocol(this.testProtocolId));

		try {
			this.registry.unregisterTransferProtocol("haha");
			Assert.fail("shouldn't be able to unregister non-existing TP");
		} catch (final IllegalArgumentException e) {
		}
	}

}

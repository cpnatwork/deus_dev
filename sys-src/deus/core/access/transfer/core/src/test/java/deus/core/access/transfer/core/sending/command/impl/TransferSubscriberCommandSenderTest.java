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

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.access.transfer.common.messages.TransferMessage;
import deus.core.access.transfer.common.messages.publication.connection.establish.subscribe.RequestSubscriptionMessage;
import deus.core.access.transfer.common.messages.publication.connection.terminate.UnsubscribeMessage;
import deus.core.access.transfer.core.sending.command.SubscriberCommandSender;
import deus.model.common.user.Gender;
import deus.model.common.user.UserMetadata;

/**
 * The Class TransferSubscriberCommandSenderTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml",
		"/deus/core/access/transfer/core/test.xml" })
public class TransferSubscriberCommandSenderTest extends
		AbstractCommandSenderTest {

	/** The transfer subscriber command sender. */
	@Autowired
	private SubscriberCommandSender transferSubscriberCommandSender;

	/**
	 * Test subscribe.
	 */
	@Test
	public void testSubscribe() {
		final UserMetadata subscriberMetadata = new UserMetadata("Bob",
				Gender.male);

		this.transferSubscriberCommandSender.subscribe(this.subscriberId,
				this.publisherId, subscriberMetadata);

		final TransferMessage expectedMessage = new RequestSubscriptionMessage(
				subscriberMetadata);
		this.setTids(expectedMessage, this.subscriberId.getUserId(),
				this.publisherId.getUserId());

		this.testEqualsMessage(expectedMessage, this.lastSentTransferMessage);

		Assert.assertEquals(subscriberMetadata,
				((RequestSubscriptionMessage) this.lastSentTransferMessage)
						.getSubscriberMetadata());
	}

	/**
	 * Test unsubscribe.
	 */
	@Test
	public void testUnsubscribe() {
		this.transferSubscriberCommandSender.unsubscribe(this.subscriberId,
				this.publisherId);

		final TransferMessage expectedMessage = new UnsubscribeMessage();
		this.setTids(expectedMessage, this.subscriberId.getUserId(),
				this.publisherId.getUserId());

		this.testEqualsMessage(expectedMessage, this.lastSentTransferMessage);
	}

}

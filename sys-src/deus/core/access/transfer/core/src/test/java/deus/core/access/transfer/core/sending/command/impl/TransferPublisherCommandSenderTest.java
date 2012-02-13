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
import deus.core.access.transfer.common.messages.publication.UpdateMessage;
import deus.core.access.transfer.core.sending.command.PublisherCommandSender;
import deus.model.common.dossier.DigitalCard;
import deus.model.common.dossier.DigitalCardId;
import deus.model.common.user.id.UserUrl;
import deus.model.dccontent.PartyInformationDC;

/**
 * The Class TransferPublisherCommandSenderTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml",
		"/deus/core/access/transfer/core/test.xml" })
public class TransferPublisherCommandSenderTest extends
		AbstractCommandSenderTest {

	/** The transfer publisher command sender. */
	@Autowired
	private PublisherCommandSender transferPublisherCommandSender;

	/**
	 * Test update.
	 */
	@Test
	public void testUpdate() {
		final DigitalCard digitalCard = new PartyInformationDC(
				new DigitalCardId(
						new UserUrl("higgins", "http://www.deus.org"),
						new UserUrl("alice", "http://www.deus.org"), "surgery1"));

		this.transferPublisherCommandSender.update(this.publisherId,
				this.subscriberId, digitalCard);

		final TransferMessage expectedMessage = new UpdateMessage(digitalCard);
		this.setTids(expectedMessage, this.publisherId.getUserId(),
				this.subscriberId.getUserId());

		this.testEqualsMessage(expectedMessage, this.lastSentTransferMessage);

		Assert.assertEquals(digitalCard,
				((UpdateMessage) this.lastSentTransferMessage).getDigitalCard());
	}

}

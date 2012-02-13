package deus.core.access.transfer.core.sending.command.impl;

import static org.junit.Assert.assertEquals;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml", "/deus/core/access/transfer/core/test.xml" })
public class TransferPublisherCommandSenderTest extends AbstractCommandSenderTest {

	@Autowired
	private PublisherCommandSender transferPublisherCommandSender;


	@Test
	public void testUpdate() {
		DigitalCard digitalCard = new PartyInformationDC(new DigitalCardId(new UserUrl("higgins", "http://www.deus.org"),
				new UserUrl("alice", "http://www.deus.org"), "surgery1"));

		transferPublisherCommandSender.update(publisherId, subscriberId, digitalCard);

		TransferMessage expectedMessage = new UpdateMessage(digitalCard);
		setTids(expectedMessage, publisherId.getUserId(), subscriberId.getUserId());

		testEqualsMessage(expectedMessage, lastSentTransferMessage);

		assertEquals(digitalCard, ((UpdateMessage) lastSentTransferMessage).getDigitalCard());
	}

}

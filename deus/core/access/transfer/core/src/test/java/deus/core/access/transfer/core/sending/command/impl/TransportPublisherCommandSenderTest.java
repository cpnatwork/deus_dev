package deus.core.access.transfer.core.sending.command.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.access.transfer.core.messages.TransportMessage;
import deus.core.access.transfer.core.messages.publication.UpdateMessage;
import deus.core.access.transfer.core.sending.command.PublisherCommandSender;
import deus.model.dossier.DigitalCard;
import deus.model.dossier.DigitalCardId;
import deus.model.dossier.PartyInformationDC;
import deus.model.user.id.UserUrl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml", "/deus/core/access/transport/core/test.xml" })
public class TransportPublisherCommandSenderTest extends AbstractCommandSenderTest {

	@Autowired
	private PublisherCommandSender transportPublisherCommandSender;


	@Test
	public void testUpdate() {
		DigitalCard digitalCard = new PartyInformationDC(new DigitalCardId(new UserUrl("higgins", "deus.org"),
				new UserUrl("alice", "deus.org"), "surgery1"));

		transportPublisherCommandSender.update(subscriberId, publisherId, digitalCard);

		TransportMessage expectedMessage = new UpdateMessage(digitalCard);
		setTids(expectedMessage, publisherId, subscriberId);

		testEqualsMessage(expectedMessage, lastSentTransportMessage);

		assertEquals(digitalCard, ((UpdateMessage) lastSentTransportMessage).getDigitalCard());
	}


}

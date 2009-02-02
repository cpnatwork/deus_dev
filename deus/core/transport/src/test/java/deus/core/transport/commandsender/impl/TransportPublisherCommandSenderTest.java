package deus.core.transport.commandsender.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.transport.commandsender.PublisherCommandSender;
import deus.core.transport.message.TransportMessage;
import deus.core.transport.message.UpdateMessage;
import deus.model.dossier.deus.ForeignPatientFile;
import deus.model.dossier.generic.ForeignInformationFile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml", "/deus/core/transport/test.xml" })
public class TransportPublisherCommandSenderTest extends AbstractCommandSenderTest {

	@Autowired
	private PublisherCommandSender transportPublisherCommandSender;

	@Test
	public void testUpdate() {
		ForeignInformationFile fif = new ForeignPatientFile();
		
		transportPublisherCommandSender.update(subscriberId, publisherId, fif);

		TransportMessage expectedMessage = new UpdateMessage(fif);
		setTids(expectedMessage, publisherId, subscriberId);
		
		testEqualsMessage(expectedMessage, lastSentTransportMessage);
		
		assertEquals(fif, ((UpdateMessage)lastSentTransportMessage).getForeignInformationFile());
	}

	
}

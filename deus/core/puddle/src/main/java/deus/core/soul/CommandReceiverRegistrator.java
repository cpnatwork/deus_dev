package deus.core.soul;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deus.core.access.transport.core.receiving.command.CommandReceiverRegistry;
import deus.core.access.transport.core.receiving.command.PublisherCommandReceiver;
import deus.core.access.transport.core.receiving.command.SubscriberCommandReceiver;

@Component
public class CommandReceiverRegistrator {

	@Autowired
	private CommandReceiverRegistry registry;

	// FIXME: replace by PublisherExportedToPeer
	@Autowired
	private PublisherCommandReceiver publisherCommandReceiver;

	// FIXME: replace by SubscriberExportedToPeer
	@Autowired
	private SubscriberCommandReceiver subscriberCommandReceiver;


	@PostConstruct
	public void registerCommandReceivers() {
		registry.registerPublisherCommandReceiver(publisherCommandReceiver);
		registry.registerSubscriberCommandReceiver(subscriberCommandReceiver);
	}
	
}

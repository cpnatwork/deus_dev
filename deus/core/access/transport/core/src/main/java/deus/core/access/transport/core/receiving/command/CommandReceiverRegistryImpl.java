package deus.core.access.transport.core.receiving.command;

import org.springframework.stereotype.Component;


@Component("commandReceiverRegistry")
public class CommandReceiverRegistryImpl implements CommandReceiverRegistry {

	private PublisherCommandReceiver publisherCommandReceiver;

	private SubscriberCommandReceiver subscriberCommandReceiver;


	/* (non-Javadoc)
	 * @see deus.core.access.transport.receiving.command.CommandReceiverRegistry#getPublisherCommandReceiver()
	 */
	public PublisherCommandReceiver getPublisherCommandReceiver() {
		return publisherCommandReceiver;
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transport.receiving.command.CommandReceiverRegistry#registerPublisherCommandReceiver(deus.core.access.transport.receiving.command.PublisherCommandReceiver)
	 */
	public void registerPublisherCommandReceiver(PublisherCommandReceiver publisherCommandReceiver) {
		this.publisherCommandReceiver = publisherCommandReceiver;
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transport.receiving.command.CommandReceiverRegistry#getSubscriberCommandReceiver()
	 */
	public SubscriberCommandReceiver getSubscriberCommandReceiver() {
		return subscriberCommandReceiver;
	}


	/* (non-Javadoc)
	 * @see deus.core.access.transport.receiving.command.CommandReceiverRegistry#registerSubscriberCommandReceiver(deus.core.access.transport.receiving.command.SubscriberCommandReceiver)
	 */
	public void registerSubscriberCommandReceiver(SubscriberCommandReceiver subscriberCommandReceiver) {
		this.subscriberCommandReceiver = subscriberCommandReceiver;
	}

}

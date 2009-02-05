package deus.core.access.transport.core.receiving.command;

// FIXME: don't export getters in OSGi
public interface CommandReceiverRegistry {

	public abstract PublisherCommandReceiver getPublisherCommandReceiver();


	public abstract void registerPublisherCommandReceiver(PublisherCommandReceiver publisherCommandReceiver);


	public abstract SubscriberCommandReceiver getSubscriberCommandReceiver();


	public abstract void registerSubscriberCommandReceiver(SubscriberCommandReceiver subscriberCommandReceiver);

}
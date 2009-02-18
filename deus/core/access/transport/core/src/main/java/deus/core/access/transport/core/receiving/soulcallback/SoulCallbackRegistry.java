package deus.core.access.transport.core.receiving.soulcallback;

public interface SoulCallbackRegistry extends ExportedSoulCallbackRegistry {

	public abstract PublisherExportedToPeer getPublisher();


	public abstract SubscriberExportedToPeer getSubscriber();

}
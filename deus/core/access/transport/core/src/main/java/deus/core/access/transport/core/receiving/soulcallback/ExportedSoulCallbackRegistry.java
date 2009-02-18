package deus.core.access.transport.core.receiving.soulcallback;


public interface ExportedSoulCallbackRegistry {

	public abstract void registerPublisher(PublisherExportedToPeer publisher);


	public abstract void registerSubscriber(SubscriberExportedToPeer subscriber);

}
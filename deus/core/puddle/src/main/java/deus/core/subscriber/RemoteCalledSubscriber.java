package deus.core.subscriber;

import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.sub.PublisherMetadata;

public interface RemoteCalledSubscriber<FifContentType> {


	public void update(PublisherMetadata publisherMetadata, ForeignInformationFile<FifContentType> fif);

}

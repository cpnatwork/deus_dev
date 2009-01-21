package deus.core.subscriber;

import deus.model.dossier.generic.ForeignInformationFile;
import deus.model.sub.PublisherMetadata;
import deus.model.user.id.UserId;

public interface RemoteCalledSubscriber<Id extends UserId, FifContentType> {


	public void update(PublisherMetadata<Id> publisherMetadata, ForeignInformationFile<Id, FifContentType> fif);


}

package deus.model.sub;

import java.util.List;

import deus.model.user.id.UserId;

public interface ListOfPublishers<Id extends UserId> extends List<PublisherMetadata<Id>> {

}

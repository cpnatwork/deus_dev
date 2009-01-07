package deus.model.sub;

import java.util.List;

import deus.model.contactprofile.proj.party.PartyId;

public interface ListOfPublishers<T extends PartyId> extends List<PublisherMetadata<T>> {

}

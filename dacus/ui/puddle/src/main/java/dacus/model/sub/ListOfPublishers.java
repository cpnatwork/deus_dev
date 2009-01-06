package dacus.model.sub;

import java.util.List;

import dacus.model.contactprofile.proj.party.PartyId;

public interface ListOfPublishers<T extends PartyId> extends List<PublisherMetadata<T>> {

}

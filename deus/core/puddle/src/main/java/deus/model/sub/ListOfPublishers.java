package deus.model.sub;

import java.util.List;

import deus.model.dossier.proj.party.PartyId;

public interface ListOfPublishers<Id extends PartyId> extends List<PublisherMetadata<Id>> {

}

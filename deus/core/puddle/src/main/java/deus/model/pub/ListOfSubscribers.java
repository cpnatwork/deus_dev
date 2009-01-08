package deus.model.pub;

import java.util.List;

import deus.model.dossier.proj.party.PartyId;


public interface ListOfSubscribers<Id extends PartyId> extends List<SubscriberMetadata<Id>> {
	
}
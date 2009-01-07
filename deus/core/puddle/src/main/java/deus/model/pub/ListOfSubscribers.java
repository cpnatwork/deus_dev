package deus.model.pub;

import java.util.List;

import deus.model.contactprofile.proj.party.PartyId;


public interface ListOfSubscribers<T extends PartyId> extends List<SubscriberMetadata<T>> {
	
}
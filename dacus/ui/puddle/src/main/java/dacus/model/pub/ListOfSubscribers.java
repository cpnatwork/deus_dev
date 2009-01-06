package dacus.model.pub;

import java.util.List;

import dacus.model.contactprofile.proj.party.PartyId;


public interface ListOfSubscribers<T extends PartyId> extends List<SubscriberMetadata<T>> {
	
}
package dacus.model.pub.impl;

import java.util.ArrayList;

import dacus.model.contactprofile.proj.party.PartyId;
import dacus.model.pub.ListOfSubscribers;
import dacus.model.pub.SubscriberMetadata;

public class ListOfSubscribersImpl<T extends PartyId> extends ArrayList<SubscriberMetadata<T>> implements ListOfSubscribers<T> {

	private static final long serialVersionUID = -5115372700101022103L;

}

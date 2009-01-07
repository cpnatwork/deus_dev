package deus.model.contactprofile;

import java.util.List;

import deus.model.contactprofile.proj.party.PartyId;
import deus.model.user.UserMetadata;

public class InformationProfile<T extends PartyId> {
	
	private UserMetadata<T> userMetadata;
	
	private List<DigitalCard> digitalCards;

}

package deus.model.ifcontent;

import deus.model.dossier.proj.party.Party;
import deus.model.user.id.UserId;

public class PartyInformationDC extends DigitalCard {

	private Party party;
	
	public PartyInformationDC(UserId contributorId, UserId cpId, String nameOfDcInLodEhr) {
		super(contributorId, cpId, nameOfDcInLodEhr);
	}
	
	public Party getPartyInformation() {
		return party;
	}
	
	public void setPartyInformation(Party partyInformation) {
		if(!partyInformation.getId().equals(getCpId()))
			throw new IllegalArgumentException("passed a party information with an ID not equal to the ID of the CP of this digital card!");
		party = partyInformation;
	}

}

package deus.model.dccontent;

import deus.model.common.dossier.DigitalCard;
import deus.model.common.dossier.DigitalCardId;
import deus.model.dccontent.party.Party;

public class PartyInformationDC extends DigitalCard {

	private Party party;
	
	public PartyInformationDC(DigitalCardId digitalCardId) {
		super(digitalCardId);
	}

	public Party getPartyInformation() {
		return party;
	}
	
	public void setPartyInformation(Party partyInformation) {
		if(!partyInformation.getId().equals(getDigitalCardId().getCpId()))
			throw new IllegalArgumentException("passed a party information with an ID not equal to the ID of the CP of this digital card!");
		party = partyInformation;
	}

}

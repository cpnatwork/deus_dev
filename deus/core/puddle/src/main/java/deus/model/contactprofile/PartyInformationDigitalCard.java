package deus.model.contactprofile;

import deus.model.contactprofile.proj.party.Party;

public class PartyInformationDigitalCard extends DigitalCard {

	private Party party;


	public Party getParty() {
		return party;
	}


	public void setParty(Party party) {
		this.party = party;
	}

}

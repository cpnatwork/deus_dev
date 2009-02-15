package deus.model.dossier;

import deus.model.dossier.proj.party.Party;
import deus.model.user.id.UserId;

public class PartyInformationDC extends ContainerCard<Party> {

	public PartyInformationDC(UserId contributorId, UserId cpId, String nameOfDcInLodEhr) {
		super(contributorId, cpId, nameOfDcInLodEhr);
	}
	
	public Party getPartyInformation() {
		return root;
	}
	
	public void setPartyInformation(Party partyInformation) {
		if(!partyInformation.getId().equals(getCpId()))
			throw new RuntimeException("passed a party information with an ID not equal to the id of the CP of this digital card!");
		root = partyInformation;
	}

}

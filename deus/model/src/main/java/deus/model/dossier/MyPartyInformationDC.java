package deus.model.dossier;

import deus.model.user.id.UserId;

public class MyPartyInformationDC extends PartyInformationDC {

	public MyPartyInformationDC(UserId myUserId) {
		super(new DigitalCardId(myUserId, myUserId, "my party information dc"));
	}

}

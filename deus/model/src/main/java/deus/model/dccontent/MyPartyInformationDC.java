package deus.model.dccontent;

import deus.model.common.dossier.DigitalCardId;
import deus.model.common.user.id.UserId;

@Deprecated
public class MyPartyInformationDC extends PartyInformationDC {

	public MyPartyInformationDC(UserId myUserId) {
		super(new DigitalCardId(myUserId, myUserId, "my party information dc"));
	}

}

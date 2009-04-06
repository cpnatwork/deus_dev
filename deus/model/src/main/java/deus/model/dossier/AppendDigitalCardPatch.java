package deus.model.dossier;

import deus.model.dc.DigitalCard;
import deus.model.user.id.UserId;

public class AppendDigitalCardPatch extends AbstractPatch {

	private DigitalCard digitalCardToAppend;


	public AppendDigitalCardPatch(UserId cpId) {
		super(cpId);
	}


	public DigitalCard getDigitalCardToAppend() {
		return digitalCardToAppend;
	}


	public void setDigitalCardToAppend(DigitalCard digitalCardToAppend) {
		this.digitalCardToAppend = digitalCardToAppend;
	}

}

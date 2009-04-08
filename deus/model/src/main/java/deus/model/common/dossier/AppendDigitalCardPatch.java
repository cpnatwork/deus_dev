package deus.model.common.dossier;

import deus.model.common.user.id.UserId;

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

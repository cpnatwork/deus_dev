package deus.model.dossier;

import deus.model.user.id.UserId;

abstract class AbstractPatch implements Patch {

	private final UserId cpId;


	public AbstractPatch(UserId cpId) {
		this.cpId = cpId;
	}


	@Override
	public UserId getCpId() {
		return cpId;
	}

}

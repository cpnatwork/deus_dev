package deus.model.common.dossier;

import deus.model.common.user.id.UserId;

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

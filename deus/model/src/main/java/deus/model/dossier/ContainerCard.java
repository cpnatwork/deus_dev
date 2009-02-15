package deus.model.dossier;

import deus.model.user.id.UserId;


abstract class ContainerCard<T> extends DigitalCard {
	
	protected T root;

	
	public ContainerCard(UserId contributorId, UserId cpId, String nameOfDcInLodEhr) {
		super(contributorId, cpId, nameOfDcInLodEhr);
	}

}

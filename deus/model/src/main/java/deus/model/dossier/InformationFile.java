package deus.model.dossier;

import java.util.Set;

import deus.model.user.id.UserId;

public abstract class InformationFile {

	private final UserId ownerId;

	private final Set<DigitalCard> digitalCards;


	public InformationFile(UserId ownerId, Set<DigitalCard> digitalCards) {
		super();
		this.ownerId = ownerId;
		this.digitalCards = digitalCards;
	}


	/**
	 * Returns the ID of the owner of this information file.
	 * In the case of a PIF, this is the ID of the concerned person.
	 * In the case of a FIF, this is the ID of the person owning the FIF, not the ID of the CP!
	 * 
	 * @return
	 */
	public UserId getOwnerId() {
		return ownerId;
	}


	public Set<DigitalCard> getDigitalCards() {
		return digitalCards;
	}

}

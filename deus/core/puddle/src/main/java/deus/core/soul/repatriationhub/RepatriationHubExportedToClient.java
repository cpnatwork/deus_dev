package deus.core.soul.repatriationhub;

import deus.model.dc.DigitalCard;
import deus.model.user.id.UserId;

public interface RepatriationHubExportedToClient {

	// TODO: remove this method (since a deus user id is required, a subsystem at contr
	// FIXME: edit javadoc
	/**
	 * This method is used to contribute a digital card to a foreign PIF, i.e. the informationProvider is not the owner of the
	 * PIF and the contribution is checked by adding an attention element to the barker. Only after the decision to
	 * contribute this digital card is made, it is committed to the PIF.
	 * 
	 * 
	 * @throws IllegalArgumentException if the ID of the user does not match the ID of the CP in the passed digital
	 *             card, or if the ID of the informationProvider does not match the informationProvider ID in the passed digital card.
	
	 * 
	 * @param repatriatedDigitalCard	the digital card to contribute
	 * @param contributorId		the user ID of the informationProvider
	 */
	@Deprecated
	public abstract void fireAndForgetAccept(UserId cpId, DigitalCard repatriatedDigitalCard);

	
}

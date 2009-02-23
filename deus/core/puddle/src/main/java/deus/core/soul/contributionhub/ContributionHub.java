package deus.core.soul.contributionhub;

import deus.model.dossier.DigitalCard;
import deus.model.user.id.UserId;


/**
 * This system interface is responsible for receiving contributed digital cards (either from the user itself or from
 * another user) to be committed into the PIF.
 * 
 * The passed ID of the contributor must match the ID of the contributor in the digital card!
 * 
 * The ID of the user, to which this contribution counter belongs must match the ID of the CP in the digital card!
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface ContributionHub { // extends ContributionHubExportedToPeer, ContributionHubExportedToClient {


	/**
	 * This method is used to contribute a digital card to a foreign PIF, i.e. the contributor is not the owner of the
	 * PIF and the contribution is checked by adding an attention element to the barker. Only after the decision to
	 * contribute this digital card is made, it is committed to the PIF.
	 * 
	 * 
	 * @throws IllegalArgumentException if the ID of the user does not match the ID of the CP in the passed digital
	 *             card, or if the ID of the contributor does not match the contributor ID in the passed digital card.
	
	 * 
	 * @param contributedDigitalCard	the digital card to contribute
	 * @param contributorId		the user ID of the contributor
	 */
	public abstract void contributeOther(UserId userId, DigitalCard contributedDigitalCard, UserId contributorId);

	
}

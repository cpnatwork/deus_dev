package deus.core.soul.contribution.hub;

import deus.model.dossier.DigitalCard;


public interface ContributionHubExportedToClient {

	/**
	 * This method is used to self-contribute a digital card to the PIF, i.e. the contributor is the owner of the PIF
	 * and the contribution is not checked by adding an attention element to the barker but committed directly to the
	 * PIF.
	 * 
	 * @throws IllegalArgumentException if the ID of the user does not match the CP ID in the passed digital card.
	 * 
	 * @param contributedDigitalCard the digital card to contribute to the PIF.
	 */
	public void contributeSelf(DigitalCard contributedDigitalCard);
	
}
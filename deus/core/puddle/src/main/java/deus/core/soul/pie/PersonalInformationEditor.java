package deus.core.soul.pie;

import deus.model.dossier.DigitalCard;
import deus.model.pie.PersonalInformationFile;
import deus.model.user.id.UserId;

public interface PersonalInformationEditor {

	/**
	 * Plain edit of PIF without any restrictions.
	 * 
	 * @param userId
	 * @param personalInformationFile
	 */
	public void updatePersonalInformationFile(UserId cpId, PersonalInformationFile personalInformationFile);


	/**
	 * This method is used to self-contribute a digital card to the PIF, i.e. the contributor is the owner of the PIF
	 * and the contribution is not checked by adding an attention element to the barker but committed directly to the
	 * PIF.
	 * 
	 * @throws IllegalArgumentException if the ID of the user does not match the CP ID in the passed digital card.
	 * 
	 * @param contributedDigitalCard the digital card to contribute to the PIF.
	 */
	public void contributeDigitalCard(UserId cpId, DigitalCard digitalCard);


}

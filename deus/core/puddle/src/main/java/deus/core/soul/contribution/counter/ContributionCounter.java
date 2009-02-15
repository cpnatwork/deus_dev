package deus.core.soul.contribution.counter;

import deus.model.dossier.DigitalCard;
import deus.model.user.id.UserId;

/**
 * This system interface is responsible for receiving contributed digital cards (either from the user itself or from
 * another user) to be committed into the PIF.
 * 
 * The passed ID of the contributor must match the ID of the contributor in the digital card!
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public interface ContributionCounter {

	public void contributeSelf(DigitalCard contributedDigitalCard);


	public void contributeOther(DigitalCard contributedDigitalCard, UserId contributorId);

}

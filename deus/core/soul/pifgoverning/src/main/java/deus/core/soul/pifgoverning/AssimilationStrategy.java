package deus.core.soul.pifgoverning;

import deus.model.common.dossier.DigitalCard;
import deus.model.common.dossier.InformationFile;
import deus.model.common.dossier.Patch;

/**
 * Implementations of this strategy realize different update semantics, when a digital card for a given
 * FIF is received.
 * 
 * Two different scenarios can be distinguised:
 * 1. The received DC is new, so no DC with the same primary key is contained in the FIF
 * 2. There is already a DC with the primary key of the received DC. A kind of merge must be implemented
 * (e.g. either a simple replace, or an append, or a merge, or more complex versioning)
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
public interface AssimilationStrategy {

	public Patch update(InformationFile fif, DigitalCard digitalCard);

}
package deus.core.soul.contribution.update;

import deus.model.dossier.DigitalCard;


/**
 * This interface is responsible for committing new digital cards into the PIF. A strategy for updating
 * the PIF can be used.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
public interface Updater {

	public void commit(DigitalCard digitalCard);
	
}

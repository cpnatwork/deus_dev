package deus.core.soul.common.pifupdate;

import deus.model.ifcontent.DigitalCard;
import deus.model.user.id.UserId;


/**
 * This interface is responsible for committing new digital cards into the PIF. A strategy for updating
 * the PIF can be used.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
public interface Updater {

	public void commit(UserId cpId, DigitalCard digitalCard);
	
}

package deus.model.common.user.frids;

import deus.model.common.user.id.UserId;


/**
 * Identifies a DEUS account assuming the functional role 'Subscriber'.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
public class SubscriberId extends FunctionalRoleId {

	public SubscriberId(UserId userId) {
		super(userId);
	}

}

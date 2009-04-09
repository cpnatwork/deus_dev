package deus.model.common.user.frids;

import deus.model.common.user.id.UserId;

/**
 * Identifies a DEUS account assuming the functional role 'Repatriation Authority'.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
public class RepatriationAuthorityId extends FunctionalRoleId {

	public RepatriationAuthorityId(UserId userId) {
		super(userId);
	}

}

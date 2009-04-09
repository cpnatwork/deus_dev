package deus.model.common.user.frids;

import deus.model.common.user.id.UserId;


/**
 * Identifies a DEUS account assuming the functional role 'Contributor'.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
public class ContributorId extends FunctionalRoleId {

	public ContributorId(UserId userId) {
		super(userId);
	}

}

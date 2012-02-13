package deus.model.common.user.frids;

import deus.model.common.user.id.UserId;

/**
 * ID, which identifies a functional role (Functional Role ID = FRID). It contains a UserID.
 * 
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 * 
 */
abstract class FunctionalRoleId {

	private final UserId userId;


	public FunctionalRoleId(UserId userId) {
		super();
		this.userId = userId;
	}


	public UserId getUserId() {
		return userId;
	}

}

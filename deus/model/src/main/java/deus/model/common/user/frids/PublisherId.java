package deus.model.common.user.frids;

import deus.model.common.user.id.UserId;

/**
 * Identifies a DEUS account assuming the functional role 'Publisher'.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
public class PublisherId extends FunctionalRoleId {

	public PublisherId(UserId userId) {
		super(userId);
	}

}

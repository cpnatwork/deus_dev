package deus.model.common.user.frids;

import java.io.Serializable;

import deus.model.common.user.id.UserId;


/**
 * Identifies a DEUS account assuming the functional role 'Contributor'.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
@SuppressWarnings("serial")
public class ContributorId extends FunctionalRoleId implements Serializable {

	public ContributorId(UserId userId) {
		super(userId);
	}

}

package deus.model.common.user.frids;

import java.io.Serializable;

import deus.model.common.user.id.UserId;

/**
 * Identifies a DEUS account assuming the functional role 'Publisher'.
 * 
 * @author Florian Rampp (Florian.Rampp@informatik.stud.uni-erlangen.de)
 *
 */
@SuppressWarnings("serial")
public class PublisherId extends FunctionalRoleId implements Serializable {

	public PublisherId(UserId userId) {
		super(userId);
	}

}

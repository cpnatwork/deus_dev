package deus.model.common.user.id;


//FIXME: REMOVE HIBERNATE STUFF!
//@SuppressWarnings("serial")
//@Entity
public class UserXri extends UserId {

	public UserXri(String xri) {
		// FIXME: what is the username of an xri?
		super(xri);
	}


	public String getXri() {
		return getUsername();
	}


	@Override
	public UserIdType getType() {
		return UserIdType.xri;
	}


	@Override
	public String getId() {
		return getXri();
	}


	@Override
	public String toString() {
		return getId();
	}


	@Override
	public int hashCode() {
		return super.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}

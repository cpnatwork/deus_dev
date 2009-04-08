package deus.model.common.user.id;


//FIXME: REMOVE HIBERNATE STUFF!
//@SuppressWarnings("serial")
//@Entity
public class UserXri extends UserId {
	String xri = null;
	
	public UserXri(String xri) {
		super();
		this.xri = xri;
	}

	public String getXri() {
		return xri;
	}

	public void setXri(String xri) {
		this.xri = xri;
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((xri == null) ? 0 : xri.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserXri other = (UserXri) obj;
		if (xri == null) {
			if (other.xri != null)
				return false;
		} else if (!xri.equals(other.xri))
			return false;
		return true;
	}

}

package deus.model.common.user.id;

import java.io.Serializable;

@SuppressWarnings("serial")
abstract public class UserId implements Serializable {

	private String username = null;


	public UserId(String username) {
		super();
		this.username = username;
	}


	/**
	 * The essential user name.
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		UserId other = (UserId) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		}
		else if (!username.equals(other.username))
			return false;
		return true;
	}


	/**
	 * The type of the User ID.
	 * 
	 * @return
	 */
	abstract public UserIdType getType();


	/**
	 * The full-fledged String representation of the User ID
	 * 
	 * @return
	 */
	abstract public String getId();

}

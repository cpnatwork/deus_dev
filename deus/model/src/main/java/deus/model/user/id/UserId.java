package deus.model.user.id;

import java.io.Serializable;

// FIXME: REMOVE HIBERNATE STUFF!
//@SuppressWarnings("serial")
//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
abstract public class UserId implements Serializable {

	private String username = null;


	/**
	 * The essential user name.
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	abstract public int hashCode();


	abstract public boolean equals(Object obj);


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

package deus.model.user.id;

import javax.persistence.Embeddable;

@Embeddable
abstract public class UserId {
	
	abstract public int hashCode();
	
	abstract public boolean equals(Object obj);
	
	abstract public UserIdType getType();
	
	abstract public String getId();

}

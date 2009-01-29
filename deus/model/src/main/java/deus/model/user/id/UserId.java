package deus.model.user.id;


public interface UserId {
	
	public int hashCode();
	
	public boolean equals(Object obj);
	
	public UserIdType getType();

}

package deus.model.user.id;

public class UserXri implements UserId {

	@Override
	public UserIdType getType() {
		return UserIdType.xri;
	}

}

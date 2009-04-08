package deus.core.soul.accountadmin.registrator;

import deus.model.common.user.id.UserId;

public interface UserRegistrationStateObserver {
	
	public void registered(UserId userId);
	
	public void unregistered(UserId userId);

}

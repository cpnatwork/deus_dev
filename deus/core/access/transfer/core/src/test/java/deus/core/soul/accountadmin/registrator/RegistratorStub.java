package deus.core.soul.accountadmin.registrator;

import deus.core.soul.accountadmin.registrator.RegistratorExportedToSubsystems;
import deus.core.soul.accountadmin.registrator.UserRegistrationStateObserver;

public class RegistratorStub implements RegistratorExportedToSubsystems {

	@Override
	public void addUserRegistrationStateObserver(UserRegistrationStateObserver observer) {
	}


	@Override
	public void removeUserRegistrationStateObserver(UserRegistrationStateObserver observer) {
	}

}

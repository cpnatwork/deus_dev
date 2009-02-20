package deus.gatekeeper.registrator;

import deus.model.user.id.UserId;


public interface Registrator {

	public void register(RegistrationInformation registrationInformation);


	public void unregister(UserId userId);

	

	public void addUserRegistrationStateObserver(UserRegistrationStateObserver observer);


	public void removeUserRegistrationStateObserver(UserRegistrationStateObserver observer);

}

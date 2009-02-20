package deus.gatekeeper.registrator;

import deus.gatekeeper.puddle.RegistrationInformation;
import deus.model.user.id.UserId;


public interface Registrator {

	public void register(RegistrationInformation registrationInformation);


	public void unregister(UserId userId);

	
	public boolean existsLocalUsername(String localUserName);

	
	

	public void addUserRegistrationStateObserver(UserRegistrationStateObserver observer);


	public void removeUserRegistrationStateObserver(UserRegistrationStateObserver observer);

}

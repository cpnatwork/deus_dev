package deus.gatekeeper.registrator;

import deus.gatekeeper.puddle.RegistrationInformation;


public interface Registrator {

	public void register(RegistrationInformation registrationInformation);


	public void unregister(String localUsername);

	
	public boolean existsLocalUsername(String localUserName);

	
	

	public void addUserRegistrationStateObserver(UserRegistrationStateObserver observer);


	public void removeUserRegistrationStateObserver(UserRegistrationStateObserver observer);

}

package deus.core.soul.accountadmin.registrator;


public interface RegistratorExportedToSubsystems {

	public abstract void addUserRegistrationStateObserver(UserRegistrationStateObserver observer);


	public abstract void removeUserRegistrationStateObserver(UserRegistrationStateObserver observer);

}
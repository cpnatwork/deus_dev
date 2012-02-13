package deus.core.soul.gatekeeper.cerberus;


public interface CerberusExportedToSubsystems {

	public abstract void addUserLoginStateObserver(UserLoginStateObserver observer);


	public abstract void removeUserLoginStateObserver(UserLoginStateObserver observer);

}
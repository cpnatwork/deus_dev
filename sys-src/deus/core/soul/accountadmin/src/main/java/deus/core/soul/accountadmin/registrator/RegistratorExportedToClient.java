package deus.core.soul.accountadmin.registrator;

import deus.model.accountadmin.RegistrationInformation;


public interface RegistratorExportedToClient {

	public abstract void register(RegistrationInformation registrationInformation);


	public abstract void unregister(String localUsername);


	public abstract boolean existsLocalUsername(String localUserName);

}
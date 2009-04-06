package deus.core.soul.accountadmin.registrator;

import deus.core.soul.accountadmin.model.RegistrationInformation;


public interface RegistratorExportedToClient {

	public abstract void register(RegistrationInformation registrationInformation);


	public abstract void unregister(String localUsername);


	public abstract boolean existsLocalUsername(String localUserName);

}
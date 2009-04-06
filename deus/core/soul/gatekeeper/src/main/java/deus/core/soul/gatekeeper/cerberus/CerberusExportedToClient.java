package deus.core.soul.gatekeeper.cerberus;

import deus.model.gatekeeper.LoginCredentials;
import deus.model.user.id.UserId;


public interface CerberusExportedToClient {

	public abstract UserId login(LoginCredentials credentials);


	public abstract void logout(String localUsername);

}
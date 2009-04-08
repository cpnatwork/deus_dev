package deus.core.soul.gatekeeper.cerberus;

import deus.model.common.user.id.UserId;
import deus.model.gatekeeper.LoginCredentials;


public interface CerberusExportedToClient {

	public abstract UserId login(LoginCredentials credentials);


	public abstract void logout(String localUsername);

}
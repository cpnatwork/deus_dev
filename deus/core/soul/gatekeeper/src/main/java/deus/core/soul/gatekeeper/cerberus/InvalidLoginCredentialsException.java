package deus.core.soul.gatekeeper.cerberus;

import deus.model.gatekeeper.LoginCredentials;

public class InvalidLoginCredentialsException extends RuntimeException {

	private static final long serialVersionUID = 8101222420761567833L;

	private final LoginCredentials loginCredentials;


	public InvalidLoginCredentialsException(LoginCredentials loginCredentials) {
		super();
		this.loginCredentials = loginCredentials;
	}


	public LoginCredentials getLoginCredentials() {
		return loginCredentials;
	}

}

package deus.core.soul.gatekeeper.soul;

public class LoginCredentials {

	private final String localUsername;
	private final String password;


	public LoginCredentials(String localUsername, String password) {
		super();
		this.localUsername = localUsername;
		this.password = password;
	}


	public String getLocalUsername() {
		return localUsername;
	}


	public String getPassword() {
		return password;
	}

}

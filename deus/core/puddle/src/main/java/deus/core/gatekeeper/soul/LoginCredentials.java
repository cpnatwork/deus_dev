package deus.core.gatekeeper.soul;

public class LoginCredentials {
	private String Username;
	private String Password;


	public LoginCredentials(String username, String password) {
		super();
		Username = username;
		Password = password;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}
}

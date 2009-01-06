package dacus.storage.party;

import java.net.URL;

public class XmppPartyId implements PartyId {

	private URL server;
	private String username;


	public URL getServer() {
		return server;
	}


	public void setServer(URL server) {
		this.server = server;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

}

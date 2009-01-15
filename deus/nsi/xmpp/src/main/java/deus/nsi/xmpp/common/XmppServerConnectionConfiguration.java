package deus.nsi.xmpp.common;

import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;

public class XmppServerConnectionConfiguration {

	private boolean compression;

	private boolean saslAuthentication;

	private SecurityMode securityMode;


	public boolean isCompression() {
		return compression;
	}


	public void setCompression(boolean compression) {
		this.compression = compression;
	}


	public boolean isSaslAuthentication() {
		return saslAuthentication;
	}


	public void setSaslAuthentication(boolean saslAuthentication) {
		this.saslAuthentication = saslAuthentication;
	}


	public SecurityMode getSecurityMode() {
		return securityMode;
	}


	public void setSecurityMode(SecurityMode securityMode) {
		this.securityMode = securityMode;
	}

}

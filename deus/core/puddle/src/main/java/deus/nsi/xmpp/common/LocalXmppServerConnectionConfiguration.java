package deus.nsi.xmpp.common;

import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;

public class LocalXmppServerConnectionConfiguration {

	private boolean enableCompression;

	private boolean enableSaslAuthentication;

	private SecurityMode securityMode;


	public boolean isEnableCompression() {
		return enableCompression;
	}


	public void setEnableCompression(boolean enableCompression) {
		this.enableCompression = enableCompression;
	}


	public boolean isEnableSaslAuthentication() {
		return enableSaslAuthentication;
	}


	public void setEnableSaslAuthentication(boolean enableSaslAuthentication) {
		this.enableSaslAuthentication = enableSaslAuthentication;
	}


	public SecurityMode getSecurityMode() {
		return securityMode;
	}


	public void setSecurityMode(SecurityMode securityMode) {
		this.securityMode = securityMode;
	}

}

package deus.core.access.transfer.plugins.xmpp.common;

import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;

public class XmppServerConnectionConfiguration {

	private String localXmppServerAddress;


	private boolean compression;

	private boolean saslAuthentication;

	private SecurityMode securityMode;


	public String getLocalXmppServerAddress() {
		return localXmppServerAddress;
	}


	public void setLocalXmppServerAddress(String localXmppServerAddress) {
		this.localXmppServerAddress = localXmppServerAddress;
	}


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

package deus.nsi.xmpp.protocol;

public abstract class XmppProtocolException extends XmppException {

	private static final long serialVersionUID = 3967604870797122056L;
	
	public abstract int getXmppErrorCode();

}

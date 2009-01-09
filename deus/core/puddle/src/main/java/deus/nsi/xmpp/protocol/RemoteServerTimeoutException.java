package deus.nsi.xmpp.protocol;

public class RemoteServerTimeoutException extends XmppProtocolException {

	private static final long serialVersionUID = -6002521685807861618L;

	@Override
	public int getXmppErrorCode() {
		return 504;
	}

}

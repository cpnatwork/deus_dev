package deus.nsi.xmpp.protocol;

public class RemoteServerErrorException extends XmppProtocolException {

	private static final long serialVersionUID = 2112351347755147198L;

	@Override
	public int getXmppErrorCode() {
		return 502;
	}

}

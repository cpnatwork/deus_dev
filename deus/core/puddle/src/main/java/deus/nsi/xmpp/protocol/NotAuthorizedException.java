package deus.nsi.xmpp.protocol;

public class NotAuthorizedException extends XmppProtocolException {

	private static final long serialVersionUID = 7722779067414784085L;

	@Override
	public int getXmppErrorCode() {
		return 401;
	}

}

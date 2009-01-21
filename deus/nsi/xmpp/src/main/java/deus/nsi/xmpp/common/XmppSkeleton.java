package deus.nsi.xmpp.common;


public interface XmppSkeleton {

	// TODO: think about this signature: attach(XmppConversation)
	public abstract void connect();


	// TODO: think about this signature: detach()
	public abstract void disconnect();

}
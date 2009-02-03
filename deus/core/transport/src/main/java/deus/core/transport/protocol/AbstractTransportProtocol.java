package deus.core.transport.protocol;

import deus.core.transport.message.sender.MessageSender;
import deus.core.transport.protocol.callback.LoginEventCallback;
import deus.core.transport.protocol.callback.RegistrationEventCallback;

public abstract class AbstractTransportProtocol implements TransportProtocol {

	private MessageSender messageSender;

	private LoginEventCallback loginEventCallback;

	private RegistrationEventCallback registrationEventCallback;

	private TransportIdUserIdMapper transportIdUserIdMapper;


	/* (non-Javadoc)
	 * @see deus.core.transport.protocol.TransportProtocol#getMessageSender()
	 */
	public MessageSender getMessageSender() {
		return messageSender;
	}


	public void setMessageSender(MessageSender messageSender) {
		this.messageSender = messageSender;
	}


	/* (non-Javadoc)
	 * @see deus.core.transport.protocol.TransportProtocol#getLoginEventCallback()
	 */
	public LoginEventCallback getLoginEventCallback() {
		return loginEventCallback;
	}


	public void setLoginEventCallback(LoginEventCallback loginEventCallback) {
		this.loginEventCallback = loginEventCallback;
	}


	/* (non-Javadoc)
	 * @see deus.core.transport.protocol.TransportProtocol#getRegistrationEventCallback()
	 */
	public RegistrationEventCallback getRegistrationEventCallback() {
		return registrationEventCallback;
	}


	public void setRegistrationEventCallback(RegistrationEventCallback registrationEventCallback) {
		this.registrationEventCallback = registrationEventCallback;
	}


	/* (non-Javadoc)
	 * @see deus.core.transport.protocol.TransportProtocol#getTransportIdUserIdMapper()
	 */
	public TransportIdUserIdMapper getTransportIdUserIdMapper() {
		return transportIdUserIdMapper;
	}


	public void setTransportIdUserIdMapper(TransportIdUserIdMapper transportIdUserIdMapper) {
		this.transportIdUserIdMapper = transportIdUserIdMapper;
	}

	/* (non-Javadoc)
	 * @see deus.core.transport.protocol.TransportProtocol#getTransportProtocolId()
	 */
	public abstract String getId();
	
	
	public String toString() {
		return getId();
	}
	
}

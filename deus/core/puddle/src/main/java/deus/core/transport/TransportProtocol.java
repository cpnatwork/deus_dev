package deus.core.transport;

import deus.core.transport.id.TransportIdUserIdMapper;
import deus.core.transport.message.sender.MessageSender;
import deus.core.transport.protocolregistry.callback.LoginEventCallback;
import deus.core.transport.protocolregistry.callback.RegistrationEventCallback;

public class TransportProtocol {

	private MessageSender messageSender;

	private LoginEventCallback loginEventCallback;

	private RegistrationEventCallback registrationEventCallback;

	private TransportIdUserIdMapper transportIdUserIdMapper;


	public MessageSender getMessageSender() {
		return messageSender;
	}


	public void setMessageSender(MessageSender messageSender) {
		this.messageSender = messageSender;
	}


	public LoginEventCallback getLoginEventCallback() {
		return loginEventCallback;
	}


	public void setLoginEventCallback(LoginEventCallback loginEventCallback) {
		this.loginEventCallback = loginEventCallback;
	}


	public RegistrationEventCallback getRegistrationEventCallback() {
		return registrationEventCallback;
	}


	public void setRegistrationEventCallback(RegistrationEventCallback registrationEventCallback) {
		this.registrationEventCallback = registrationEventCallback;
	}


	public TransportIdUserIdMapper getTransportIdUserIdMapper() {
		return transportIdUserIdMapper;
	}


	public void setTransportIdUserIdMapper(TransportIdUserIdMapper transportIdUserIdMapper) {
		this.transportIdUserIdMapper = transportIdUserIdMapper;
	}


}

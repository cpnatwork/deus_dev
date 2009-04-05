package deus.core.access.transfer.common.protocol;

import deus.core.access.transfer.common.protocol.callback.LoginEventCallback;
import deus.core.access.transfer.common.protocol.callback.RegistrationEventCallback;
import deus.core.access.transfer.common.protocol.mapper.UserIdMapper;
import deus.core.access.transfer.common.protocol.messagesender.MessageSender;

public final class TransferProtocolImpl implements TransferProtocol {

	private String protocolId;


	private MessageSender messageSender;

	private LoginEventCallback loginEventCallback;

	private RegistrationEventCallback registrationEventCallback;

	private UserIdMapper userIdMapper;


	public String getProtocolId() {
		return protocolId;
	}


	public void setProtocolId(String protocolId) {
		this.protocolId = protocolId;
	}


	@Override
	public MessageSender getMessageSender() {
		return messageSender;
	}


	public void setMessageSender(MessageSender messageSender) {
		this.messageSender = messageSender;
	}


	@Override
	public LoginEventCallback getLoginEventCallback() {
		return loginEventCallback;
	}


	public void setLoginEventCallback(LoginEventCallback loginEventCallback) {
		this.loginEventCallback = loginEventCallback;
	}


	@Override
	public RegistrationEventCallback getRegistrationEventCallback() {
		return registrationEventCallback;
	}


	public void setRegistrationEventCallback(RegistrationEventCallback registrationEventCallback) {
		this.registrationEventCallback = registrationEventCallback;
	}


	@Override
	public UserIdMapper getUserIdMapper() {
		return userIdMapper;
	}


	public void setUserIdMapper(UserIdMapper userIdMapper) {
		this.userIdMapper = userIdMapper;
	}


	public String toString() {
		return getProtocolId();
	}

}

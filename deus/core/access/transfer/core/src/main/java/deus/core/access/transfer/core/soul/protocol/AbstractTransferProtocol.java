package deus.core.access.transfer.core.soul.protocol;

import deus.core.access.transfer.core.soul.mapper.UserIdMapper;
import deus.core.access.transfer.core.soul.protocol.callback.LoginEventCallback;
import deus.core.access.transfer.core.soul.protocol.callback.RegistrationEventCallback;

public abstract class AbstractTransferProtocol implements TransferProtocol {

	private MessageSender messageSender;

	private LoginEventCallback loginEventCallback;

	private RegistrationEventCallback registrationEventCallback;

	
	private UserIdMapper userIdMapper;


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


	/* (non-Javadoc)
	 * @see deus.core.access.transfer.protocol.TransferProtocol#getTransferProtocolId()
	 */
	@Override
	public abstract String getId();
	
	
	public String toString() {
		return getId();
	}
	
}

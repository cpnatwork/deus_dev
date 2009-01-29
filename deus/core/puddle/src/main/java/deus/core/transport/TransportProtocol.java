package deus.core.transport;

import deus.core.transport.callback.LoginEventCallback;
import deus.core.transport.callback.RegistrationEventCallback;
import deus.core.transport.id.LocalUserTransportIdFactory;
import deus.core.transport.sender.RemoteCommandSender;

public class TransportProtocol {

	private RemoteCommandSender remoteCommandSender;

	private LoginEventCallback loginEventCallback;

	private RegistrationEventCallback registrationEventCallback;

	private LocalUserTransportIdFactory localUserTransportIdFactory;


	public RemoteCommandSender getRemoteCommandSender() {
		return remoteCommandSender;
	}


	public void setRemoteCommandSender(RemoteCommandSender remoteCommandSender) {
		this.remoteCommandSender = remoteCommandSender;
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


	public LocalUserTransportIdFactory getLocalUserTransportIdFactory() {
		return localUserTransportIdFactory;
	}


	public void setLocalUserTransportIdFactory(LocalUserTransportIdFactory localUserTransportIdFactory) {
		this.localUserTransportIdFactory = localUserTransportIdFactory;
	}


}

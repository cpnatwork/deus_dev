package deus.core.transport.core.protocol;

import deus.core.transport.core.protocol.callback.LoginEventCallback;
import deus.core.transport.core.protocol.callback.RegistrationEventCallback;


public interface TransportProtocol {

	public abstract MessageSender getMessageSender();


	public abstract LoginEventCallback getLoginEventCallback();


	public abstract RegistrationEventCallback getRegistrationEventCallback();


	public abstract TransportIdUserIdMapper getTransportIdUserIdMapper();


	public abstract String getId();

}
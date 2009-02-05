package deus.core.access.transport.core.soul.protocol;

import deus.core.access.transport.core.soul.protocol.callback.LoginEventCallback;
import deus.core.access.transport.core.soul.protocol.callback.RegistrationEventCallback;


public interface TransportProtocol {

	public abstract MessageSender getMessageSender();


	public abstract LoginEventCallback getLoginEventCallback();


	public abstract RegistrationEventCallback getRegistrationEventCallback();


	public abstract TransportIdUserIdMapper getTransportIdUserIdMapper();


	public abstract String getId();

}
package deus.core.transport.protocol;

import deus.core.transport.message.sender.MessageSender;
import deus.core.transport.protocol.callback.LoginEventCallback;
import deus.core.transport.protocol.callback.RegistrationEventCallback;


public interface TransportProtocol {

	public abstract MessageSender getMessageSender();


	public abstract LoginEventCallback getLoginEventCallback();


	public abstract RegistrationEventCallback getRegistrationEventCallback();


	public abstract TransportIdUserIdMapper getTransportIdUserIdMapper();


	public abstract String getId();

}
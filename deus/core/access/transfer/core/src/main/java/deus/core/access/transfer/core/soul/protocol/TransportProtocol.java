package deus.core.access.transfer.core.soul.protocol;

import deus.core.access.transfer.core.soul.mapper.UserIdMapper;
import deus.core.access.transfer.core.soul.protocol.callback.LoginEventCallback;
import deus.core.access.transfer.core.soul.protocol.callback.RegistrationEventCallback;


public interface TransportProtocol {

	public abstract MessageSender getMessageSender();


	
	public abstract LoginEventCallback getLoginEventCallback();

	public abstract RegistrationEventCallback getRegistrationEventCallback();

	

	public abstract UserIdMapper getUserIdMapper();


	
	public abstract String getId();

}
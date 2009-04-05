package deus.core.access.transfer.common.protocol;

import deus.core.access.transfer.common.protocol.callback.LoginEventCallback;
import deus.core.access.transfer.common.protocol.callback.RegistrationEventCallback;
import deus.core.access.transfer.common.protocol.mapper.UserIdMapper;
import deus.core.access.transfer.common.protocol.messagesender.MessageSender;


public interface TransferProtocol {

	public abstract MessageSender getMessageSender();


	
	public abstract LoginEventCallback getLoginEventCallback();

	public abstract RegistrationEventCallback getRegistrationEventCallback();

	

	public abstract UserIdMapper getUserIdMapper();


	
	public abstract String getProtocolId();

}
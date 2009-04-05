package deus.core.access.transfer.core.sending.message;

import deus.core.access.transfer.core.soul.protocol.MessageSender;

public interface MessageSenderRegistry {

	MessageSender getMessageSender(String transferProtocolId);

}

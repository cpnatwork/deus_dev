package deus.core.access.transfer.core.sending.message;

import deus.core.access.transfer.common.protocol.messagesender.MessageSender;

public interface MessageSenderRegistry {

	MessageSender getMessageSender(String transferProtocolId);

}

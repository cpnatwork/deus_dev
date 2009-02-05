package deus.core.transport.sending.message;

import deus.core.transport.core.protocol.MessageSender;

public interface MessageSenderRegistry {

	MessageSender getMessageSender(String transportProtocolId);

}

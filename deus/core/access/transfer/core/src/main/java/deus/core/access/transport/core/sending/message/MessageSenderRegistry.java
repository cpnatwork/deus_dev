package deus.core.access.transport.core.sending.message;

import deus.core.access.transport.core.soul.protocol.MessageSender;

public interface MessageSenderRegistry {

	MessageSender getMessageSender(String transportProtocolId);

}

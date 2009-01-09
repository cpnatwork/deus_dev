package deus.nsi.xmpp.publisher.impl;

import java.util.HashMap;
import java.util.Map;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.packet.Message;

public class XmppPublisherSkeletonMessageDispatcher implements MessageListener {

	private final Map<String, MessageListener> messageListeners;
	
	public XmppPublisherSkeletonMessageDispatcher() {
		messageListeners = new HashMap<String, MessageListener>();
	}
	
	@Override
	public void processMessage(Chat chat, Message message) {
		
		String subject = message.getSubject();
		messageListeners.get(subject).processMessage(chat, message);
		
		// TODO: move this to MessageListeners
		/*
		// TODO: ifs
		if(message.getBody().equals("addObserver")) {
			// TODO: extract subscriber metadata
			SubscriberMetadata<XmppUserId> subscriberMetadata = null;
			publisher.addObserver(subscriberMetadata);
		}
		else if(message.getBody().equals("deleteObserver")) {
			// TODO: extract subscriber metadata
			SubscriberMetadata<XmppUserId> subscriberMetadata = null;
			publisher.addObserver(subscriberMetadata);
		}
		else {
			// TODO: throw exception
		}*/
	}

	public void addMessageListener(String subjectString, MessageListener messageListener) {
		messageListeners.put(subjectString, messageListener);
	}
}

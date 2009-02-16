package deus.core.access.transport.core.messages;

import deus.core.access.transport.core.soul.protocol.TransportId;
import deus.model.user.id.UserId;

public abstract class TransportMessage {

	private UserId senderId;
	private UserId receiverId;

	private TransportId senderTid;
	private TransportId receiverTid;


	public TransportMessage() {
		super();
	}


	public UserId getSenderId() {
		return senderId;
	}


	public void setSenderId(UserId senderId) {
		this.senderId = senderId;
	}


	public UserId getReceiverId() {
		return receiverId;
	}


	public void setReceiverId(UserId receiverId) {
		this.receiverId = receiverId;
	}


	public TransportId getSenderTid() {
		return senderTid;
	}


	public void setSenderTid(TransportId senderTid) {
		this.senderTid = senderTid;
	}


	public TransportId getReceiverTid() {
		return receiverTid;
	}


	public void setReceiverTid(TransportId receiverTid) {
		this.receiverTid = receiverTid;
	}

}

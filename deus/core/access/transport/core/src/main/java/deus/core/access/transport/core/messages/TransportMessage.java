package deus.core.access.transport.core.messages;

import deus.core.access.transport.core.soul.protocol.TransportId;
import deus.model.user.id.UserId;

public abstract class TransportMessage {

	private UserId senderId;

	private TransportId senderTid;
	private TransportId receiverTid;


	public TransportMessage() {
		super();
	}


	public TransportMessage(UserId senderId, TransportId senderTid, TransportId receiverTid) {
		super();
		this.senderId = senderId;
		this.senderTid = senderTid;
		this.receiverTid = receiverTid;
	}


	public UserId getSenderId() {
		return senderId;
	}


	public void setSenderId(UserId senderId) {
		this.senderId = senderId;
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

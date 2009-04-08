package deus.core.access.transfer.common.messages;

import deus.core.access.transfer.common.protocol.TransferId;
import deus.model.common.user.id.UserId;

public abstract class TransferMessage {

	private UserId senderId;
	private UserId receiverId;

	private TransferId senderTid;
	private TransferId receiverTid;


	public TransferMessage() {
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


	public TransferId getSenderTid() {
		return senderTid;
	}


	public void setSenderTid(TransferId senderTid) {
		this.senderTid = senderTid;
	}


	public TransferId getReceiverTid() {
		return receiverTid;
	}


	public void setReceiverTid(TransferId receiverTid) {
		this.receiverTid = receiverTid;
	}

}

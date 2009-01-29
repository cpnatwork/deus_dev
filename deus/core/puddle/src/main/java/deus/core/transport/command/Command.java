package deus.core.transport.command;

import deus.model.user.id.UserId;

public abstract class Command {

	private UserId senderId;
	private UserId receiverId;


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

}

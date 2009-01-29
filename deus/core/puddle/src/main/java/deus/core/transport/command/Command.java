package deus.core.transport.command;

import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

public abstract class Command {

	private UserMetadata senderMetadata;
	private UserId receiverId;


	public Command() {
		super();
	}


	public Command(UserMetadata senderMetadata, UserId receiverId) {
		super();
		this.senderMetadata = senderMetadata;
		this.receiverId = receiverId;
	}


	public UserMetadata getSenderMetadata() {
		return senderMetadata;
	}


	public void setSenderMetadata(UserMetadata senderMetadata) {
		this.senderMetadata = senderMetadata;
	}


	public UserId getReceiverId() {
		return receiverId;
	}


	public void setReceiverId(UserId receiverId) {
		this.receiverId = receiverId;
	}


}

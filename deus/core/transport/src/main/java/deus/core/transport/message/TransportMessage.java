package deus.core.transport.message;

import deus.core.transport.id.TransportId;

public abstract class TransportMessage {

	private TransportId senderTid;
	private TransportId receiverTid;


	public TransportMessage() {
		super();
	}


	public TransportMessage(TransportId senderTid, TransportId receiverTid) {
		super();
		this.senderTid = senderTid;
		this.receiverTid = receiverTid;
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

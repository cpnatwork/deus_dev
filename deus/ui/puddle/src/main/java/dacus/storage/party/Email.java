package dacus.storage.party;

import java.util.UUID;

import dacus.storage.party.common.EntityTag;

public class Email {

	private UUID id;
	private EntityTag entityTag;

	private String address;

	private boolean sendHTML;


	public Email() {
		id = UUID.randomUUID();
	}


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public EntityTag getEntityTag() {
		return entityTag;
	}


	public void setEntityTag(EntityTag entityTag) {
		this.entityTag = entityTag;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public boolean isSendHTML() {
		return sendHTML;
	}


	public void setSendHTML(boolean sendHTML) {
		this.sendHTML = sendHTML;
	}

}

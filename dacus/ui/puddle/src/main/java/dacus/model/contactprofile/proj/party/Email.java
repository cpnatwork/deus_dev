package dacus.model.contactprofile.proj.party;

import dacus.model.contactprofile.proj.party.common.EntityTag;

public class Email {

	private EntityTag entityTag;

	private String address;

	private boolean sendHTML;


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

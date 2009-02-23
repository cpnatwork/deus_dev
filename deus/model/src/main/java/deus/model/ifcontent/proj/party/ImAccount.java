package deus.model.ifcontent.proj.party;

import deus.model.ifcontent.proj.party.common.EntityTag;

public class ImAccount {

	private EntityTag entityTag;

	private ImAccountType type;
	private String account;


	public EntityTag getEntityTag() {
		return entityTag;
	}


	public void setEntityTag(EntityTag entityTag) {
		this.entityTag = entityTag;
	}


	public ImAccountType getType() {
		return type;
	}


	public void setType(ImAccountType type) {
		this.type = type;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}

}

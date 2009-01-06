package dacus.storage.party.im;

import java.util.UUID;

import dacus.storage.party.common.EntityTag;

public class ImAccount {

	private UUID id;
	private EntityTag entityTag;

	private ImAccountType type;
	private String account;

	public ImAccount() {
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

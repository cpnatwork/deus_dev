package deus.model.ifcontent.proj.party;

import deus.model.dossier.proj.party.common.EntityTag;

public class Phone {

	private EntityTag entityTag;

	// capabilities
	private boolean voice;
	private boolean text;
	private boolean video;

	private PhoneType type;

	private String number;


	public EntityTag getEntityTag() {
		return entityTag;
	}


	public void setEntityTag(EntityTag entityTag) {
		this.entityTag = entityTag;
	}


	public boolean isVoice() {
		return voice;
	}


	public void setVoice(boolean voice) {
		this.voice = voice;
	}


	public boolean isText() {
		return text;
	}


	public void setText(boolean text) {
		this.text = text;
	}


	public boolean isVideo() {
		return video;
	}


	public void setVideo(boolean video) {
		this.video = video;
	}


	public PhoneType getType() {
		return type;
	}


	public void setType(PhoneType type) {
		this.type = type;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}

}

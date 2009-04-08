package deus.model.dccontent.party;

import java.net.URL;

import deus.model.dccontent.party.common.EntityTag;

public class WebPresence {

	private EntityTag entityTag;

	private WebPresenceType type;
	private URL url;


	public EntityTag getEntityTag() {
		return entityTag;
	}


	public void setEntityTag(EntityTag entityTag) {
		this.entityTag = entityTag;
	}


	public WebPresenceType getType() {
		return type;
	}


	public void setType(WebPresenceType type) {
		this.type = type;
	}


	public URL getUrl() {
		return url;
	}


	public void setUrl(URL url) {
		this.url = url;
	}

}

package dacus.storage.party.web;

import java.net.URL;
import java.util.UUID;

import dacus.storage.party.common.EntityTag;

public class WebPresence {

	private UUID id;
	private EntityTag entityTag;

	private WebPresenceType type;
	private URL url;


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

package deus.core.access.storage.user.model;

import java.util.UUID;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;

@Entity
public class UserTO {
	
	private UUID uuid;
	
	@Embedded
	private UserId userId = null;
	@Embedded
	private UserMetadata userMetadata = null;
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public UUID getUuid() {
		return uuid;
	}
		
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	
	@NaturalId
	public UserId getUserId() {
		return userId;
	}

	public void setUserId(UserId userId) {
		this.userId = userId;
	}


	public UserMetadata getUserMetadata() {
		return userMetadata;
	}


	public void setUserMetadata(UserMetadata userMetadata) {
		this.userMetadata = userMetadata;
	}


	
}

package deus.core.access.storage.api.user.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import deus.model.user.id.UserId;

@SuppressWarnings("serial")
@Entity
public class UserPO implements Serializable {

	private UUID uuid;
	private UserId userId = null;
	private UserMetadataPO userMetadataPO = null;


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
	public String getId() {
		return userId.getId();
	}


	@OneToOne
	@PrimaryKeyJoinColumn
	public UserId getUserId() {
		return userId;
	}


	public void setUserId(UserId userId) {
		this.userId = userId;
	}


	@OneToOne
	@PrimaryKeyJoinColumn
	public UserMetadataPO getUserMetadataPO() {
		return userMetadataPO;
	}


	public void setUserMetadataPO(UserMetadataPO userMetadata) {
		this.userMetadataPO = userMetadata;
	}

}

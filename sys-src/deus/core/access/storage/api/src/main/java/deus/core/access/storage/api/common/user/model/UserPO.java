package deus.core.access.storage.api.common.user.model;

import java.io.Serializable;
import java.util.UUID;

import deus.model.common.user.id.UserId;

@SuppressWarnings("serial")
// FIXME: REMOVE HIBERNATE STUFF FROM THIS CLASS
//@Entity
public class UserPO implements Serializable {

	private UUID uuid;
	private UserId userId = null;
	private UserMetadataPO userMetadataPO = null;


//	@Id
//	@GeneratedValue(generator = "system-uuid")
//	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public UUID getUuid() {
		return uuid;
	}


	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}


//	@NaturalId
	public String getId() {
		return userId.getId();
	}


//	@OneToOne
//	@PrimaryKeyJoinColumn
	public UserId getUserId() {
		return userId;
	}


	public void setUserId(UserId userId) {
		this.userId = userId;
	}


//	@OneToOne
//	@PrimaryKeyJoinColumn
	public UserMetadataPO getUserMetadataPO() {
		return userMetadataPO;
	}


	public void setUserMetadataPO(UserMetadataPO userMetadata) {
		this.userMetadataPO = userMetadata;
	}

}

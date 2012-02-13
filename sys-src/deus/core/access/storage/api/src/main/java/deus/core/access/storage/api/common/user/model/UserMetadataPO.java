package deus.core.access.storage.api.common.user.model;

import java.util.UUID;

import deus.model.common.user.Gender;
import deus.model.common.user.UserMetadata;


// FIXME: REMOVE HIBERNATE STUFF FROM THIS CLASS
//@Entity
public class UserMetadataPO extends UserMetadata {

	private UUID uuid;


	public UserMetadataPO() {
		this.setFullName("N/A");
		this.setGender(Gender.unknown);
	}


//	@Id
//	@GeneratedValue(generator = "system-uuid")
//	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	public UUID getUuid() {
		return uuid;
	}


	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}


	/**
	 * Update all attributes by the given value object.
	 * 
	 * @param userMetadata
	 */
	public void update(UserMetadata userMetadata) {
		this.setFullName(userMetadata.getFullName());
		this.setGender(userMetadata.getGender());
	}
}

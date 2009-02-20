package deus.core.access.storage.user.model;

import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.GenericGenerator;

import deus.model.dossier.proj.party.Gender;
import deus.model.user.UserMetadata;

@Entity
public class UserMetadataPO extends UserMetadata {

	private UUID uuid;


	public UserMetadataPO() {
		this.setFullName("N/A");
		this.setGender(Gender.unknown);
	}


	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
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

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

/**
 * A local user. It requires a existing UserPO.
 * 
 * @author cpn
 *
 */
@SuppressWarnings("serial")
@Entity
public class LocalUserPO implements Serializable {

	private UUID uuid;
	private UserPO userPO = null;


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
		return getUserPO().getUserId().getId();
	}

	@OneToOne
	@PrimaryKeyJoinColumn
	public UserPO getUserPO() {
		return userPO;
	}


	public void setUserPO(UserPO userIdPO) {
		this.userPO = userIdPO;
	}

}

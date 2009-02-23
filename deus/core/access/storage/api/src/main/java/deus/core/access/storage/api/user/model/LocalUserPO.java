package deus.core.access.storage.api.user.model;

import java.io.Serializable;
import java.util.UUID;

/**
 * A local user. It requires a existing UserPO.
 * 
 * @author cpn
 *
 */
@SuppressWarnings("serial")
// FIXME: REMOVE HIBERNATE STUFF HERE
//@Entity
public class LocalUserPO implements Serializable {

	private UUID uuid;
	private UserPO userPO = null;


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
		return getUserPO().getUserId().getId();
	}

//	@OneToOne
//	@PrimaryKeyJoinColumn
	public UserPO getUserPO() {
		return userPO;
	}


	public void setUserPO(UserPO userIdPO) {
		this.userPO = userIdPO;
	}

}

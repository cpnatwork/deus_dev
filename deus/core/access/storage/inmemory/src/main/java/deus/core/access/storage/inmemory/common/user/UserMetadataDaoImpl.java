package deus.core.access.storage.inmemory.common.user;

import org.springframework.stereotype.Repository;

import deus.core.access.storage.api.common.user.UserMetadataDao;
import deus.core.access.storage.inmemory.GenericVanillaDaoImpl;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.id.UserId;

/**
 * @author cpn
 */
@Repository("userMetadataDao")
public class UserMetadataDaoImpl extends GenericVanillaDaoImpl<UserMetadata, UserId>implements UserMetadataDao {

}

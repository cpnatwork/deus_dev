package deus.core.access.storage.inmemory.common.user;

import javax.inject.Named;

import deus.core.access.storage.api.common.user.UserMetadataDao;
import deus.core.access.storage.inmemory.GenericVanillaDaoImpl;
import deus.model.common.user.UserMetadata;
import deus.model.common.user.id.UserId;

/**
 * @author cpn
 */
@Named("userMetadataDao")
public class UserMetadataDaoImpl extends GenericVanillaDaoImpl<UserMetadata, UserId>implements UserMetadataDao {

}

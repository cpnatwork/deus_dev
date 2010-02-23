/**
 * 
 */
package deus.core.access.storage.inmemory.difgoverning;

import org.springframework.stereotype.Repository;

import deus.core.access.storage.api.difgoverning.FifDao;
import deus.core.access.storage.inmemory.GenericTwofoldIdDaoImpl;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.difgoverning.ForeignInformationFile;

/**
 * @author cpn
 */
@Repository("fifDao")
public class FifDaoImpl extends GenericTwofoldIdDaoImpl<ForeignInformationFile, SubscriberId, PublisherId> implements FifDao {

}

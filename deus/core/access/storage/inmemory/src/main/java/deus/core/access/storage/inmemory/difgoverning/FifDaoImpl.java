/**
 * 
 */
package deus.core.access.storage.inmemory.difgoverning;

import deus.core.access.storage.api.difgoverning.FifDao;
import deus.core.access.storage.inmemory.GenericTwofoldIdDaoImpl;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.difgoverning.ForeignInformationFile;

/**
 * @author cpn
 */
public class FifDaoImpl extends GenericTwofoldIdDaoImpl<ForeignInformationFile, SubscriberId, PublisherId> implements FifDao {

}

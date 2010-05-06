/**
 * 
 */
package deus.core.access.storage.inmemory.difgoverning;

import javax.inject.Named;

import deus.core.access.storage.api.difgoverning.FifDao;
import deus.core.access.storage.inmemory.GenericTwofoldIdDaoImpl;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.difgoverning.ForeignInformationFile;

/**
 * @author cpn
 */
@Named("fifDao")
public class FifDaoImpl extends GenericTwofoldIdDaoImpl<ForeignInformationFile, SubscriberId, PublisherId> implements FifDao {

}

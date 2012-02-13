/**
 * 
 */
package deus.core.access.storage.inmemory.subscription;

import javax.inject.Named;

import deus.core.access.storage.api.subscription.LopDao;
import deus.core.access.storage.inmemory.GenericVanillaDaoImpl;
import deus.model.common.user.frids.SubscriberId;
import deus.model.subscription.ListOfPublishers;

/**
 * @author cpn
 *
 */
@Named("lopDao")
public class LopDaoImpl extends GenericVanillaDaoImpl<ListOfPublishers, SubscriberId> implements LopDao {

}

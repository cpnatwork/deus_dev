/**
 * 
 */
package deus.core.access.storage.inmemory.publication;

import org.springframework.stereotype.Repository;

import deus.core.access.storage.api.publication.LosDao;
import deus.core.access.storage.inmemory.GenericVanillaDaoImpl;
import deus.model.common.user.frids.PublisherId;
import deus.model.publication.ListOfSubscribers;

/**
 * @author cpn
 *
 */
@Repository("losDao")
public class LosDaoImpl extends GenericVanillaDaoImpl<ListOfSubscribers, PublisherId> implements LosDao {

}

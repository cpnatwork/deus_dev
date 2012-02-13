/**
 * 
 */
package deus.core.access.storage.inmemory.subscription;

import javax.inject.Named;

import deus.core.access.storage.api.subscription.LopEntryDao;
import deus.core.access.storage.inmemory.GenericTwofoldIdDaoImpl;
import deus.model.common.user.frids.PublisherId;
import deus.model.common.user.frids.SubscriberId;
import deus.model.subscription.LopEntry;

/**
 * @author cpn
 *
 */
@Named("lopEntryDao")
public class LopEntryDaoImpl extends GenericTwofoldIdDaoImpl<LopEntry, SubscriberId, PublisherId>implements LopEntryDao {

	@Override
	public void addNewEntity(SubscriberId subscriberId, LopEntry entry) {
		addNewEntity(subscriberId, entry.getPublisherId(), entry);
	}

	@Override
	public void updateEntity(SubscriberId subscriberId, LopEntry entry) {
		updateEntity(subscriberId, entry.getPublisherId(), entry);
	}

}

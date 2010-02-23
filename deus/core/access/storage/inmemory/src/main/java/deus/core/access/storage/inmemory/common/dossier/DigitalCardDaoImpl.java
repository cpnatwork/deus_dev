/**
 * 
 */
package deus.core.access.storage.inmemory.common.dossier;

import org.springframework.stereotype.Repository;

import deus.core.access.storage.api.common.dossier.DigitalCardDao;
import deus.core.access.storage.inmemory.GenericThreefoldIdDaoImpl;
import deus.model.common.user.frids.ContributorId;
import deus.model.common.user.id.UserId;

/**
 * @author cpn
 *
 */
@Repository("digitalCardDao")
public class DigitalCardDaoImpl extends GenericThreefoldIdDaoImpl<Object, ContributorId, UserId, String>implements DigitalCardDao {

}

/**
 * 
 */
package deus.core.access.storage.inmemory.pifgoverning;

import deus.core.access.storage.api.pifgoverning.PifDao;
import deus.core.access.storage.inmemory.GenericVanillaDaoImpl;
import deus.model.common.user.frids.RepatriationAuthorityId;
import deus.model.pifgoverning.PersonalInformationFile;

/**
 * @author cpn
 *
 */
public class PifDaoImpl extends GenericVanillaDaoImpl<PersonalInformationFile, RepatriationAuthorityId> implements PifDao {

}

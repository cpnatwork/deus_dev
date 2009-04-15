package deus.core.access.storage.inmemory.hci.attention;

import deus.core.access.storage.api.hci.attention.AttentionListDao;
import deus.core.access.storage.inmemory.GenericVanillaDaoImpl;
import deus.model.common.user.id.UserId;
import deus.model.hci.attention.AttentionList;

public class AttentionListDaoImpl extends GenericVanillaDaoImpl<AttentionList, UserId> implements AttentionListDao {


}

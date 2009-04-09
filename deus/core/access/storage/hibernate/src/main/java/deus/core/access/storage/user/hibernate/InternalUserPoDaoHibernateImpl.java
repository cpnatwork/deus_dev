package deus.core.access.storage.user.hibernate;

import java.util.UUID;

import org.springframework.stereotype.Component;

import deus.core.access.storage.api.common.user.model.UserPO;
import deus.core.access.storage.common.hibernate.GenericInternalDaoImpl;

@Component
public class InternalUserPoDaoHibernateImpl extends GenericInternalDaoImpl<UserPO, UUID, String> {

	public InternalUserPoDaoHibernateImpl() {
		super(UserPO.class);
	}

}

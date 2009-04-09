package deus.core.access.storage.user.hibernate;

import java.util.UUID;

import org.springframework.stereotype.Component;

import deus.core.access.storage.api.common.user.model.UserMetadataPO;
import deus.core.access.storage.common.hibernate.GenericTechDaoImpl;

@Component
public class InternalUserMetadataPoDaoHibernateImpl extends GenericTechDaoImpl<UserMetadataPO, UUID> {

	public InternalUserMetadataPoDaoHibernateImpl() {
		super(UserMetadataPO.class);
	}

}

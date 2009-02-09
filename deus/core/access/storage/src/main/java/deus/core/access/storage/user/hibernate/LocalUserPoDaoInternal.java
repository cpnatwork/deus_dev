package deus.core.access.storage.user.hibernate;

import java.util.UUID;

import org.springframework.stereotype.Component;

import deus.core.access.storage.common.hibernate.GenericInternalDaoImpl;
import deus.core.access.storage.user.model.LocalUserPO;

@Component
public class LocalUserPoDaoInternal extends GenericInternalDaoImpl<LocalUserPO, UUID, String> {

	public LocalUserPoDaoInternal() {
		super(LocalUserPO.class);
	}

}

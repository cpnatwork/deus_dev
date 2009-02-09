package deus.core.access.storage.user.hibernate;

import java.util.UUID;

import org.springframework.stereotype.Component;

import deus.core.access.storage.common.hibernate.GenericInternalDaoImpl;
import deus.core.access.storage.user.model.UserPO;

@Component
public class UserPoDaoInternal extends GenericInternalDaoImpl<UserPO, UUID, String> {

	public UserPoDaoInternal() {
		super(UserPO.class);
	}

}

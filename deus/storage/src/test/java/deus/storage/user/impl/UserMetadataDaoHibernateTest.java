/**
 * 
 */
package deus.storage.user.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.access.storage.common.Dao;
import deus.model.dossier.proj.party.Gender;
import deus.model.user.UserMetadata;
import deus.model.user.id.UserId;
import deus.model.user.id.UserUrl;

/**
 * @author cpn
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml", "/deus/storage/daos.xml" })
public class UserMetadataDaoHibernateTest {

	@Autowired
	private Dao<UserMetadata, String> sut;

	@Test
	public void testCreate() {
		//UserId userId = new UserUrl("testuser_UserMetadataDaoHibernateTest", "testhostname_UserMetadataDaoHibernateTest");
		sut.create(new UserMetadata( "fullname_UserMetadataDaoHibernateTest", Gender.male));
	}

	@Test
	public void testGet() {
		sut.getById("testuser_UserMetadataDaoHibernateTest");
	}

	@Test
	public void testDelete() {
		sut.deleteById("testuser_UserMetadataDaoHibernateTest");
	}
}

/**
 * 
 */
package deus.core.access.storage.user.hibernate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.access.storage.user.api.UserDao;
import deus.model.user.id.UserId;
import deus.model.user.id.UserUrl;

/**
 * @author cpn
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/context.xml", "/deus/storage/daos.xml" })
public class UserDaoTest {

	@Autowired
	private UserDao sut;


	@Test
	public void testCreate() {
		UserId userId = new UserUrl("testuser_UserMetadataDaoHibernateTest",
				"testhostname_UserMetadataDaoHibernateTest");
		sut.addNewEntity(userId);
	}


	@Test
	public void testGet() {
		sut.getByNaturalId("testuser_UserMetadataDaoHibernateTest");
	}


	@Test
	public void testDelete() {
		sut.deleteByNaturalId("testuser_UserMetadataDaoHibernateTest");
	}
}

/**
 * 
 */
package deus.core.access.storage.user.inmemory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.access.storage.api.user.UserMetadataDoRep;
import deus.model.common.user.id.UserId;
import deus.model.common.user.id.UserUrl;

/**
 * @author cpn
 * 
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "/deus/context.xml", "/deus/storage/inmemory.xml" })
public class UserDaoInmemoryTest {

	@Autowired
	private UserMetadataDoRep sut;


	@Test
	public void testCreate() {
//		UserId userId = new UserUrl("testuser_UserDaoTest", "testhostname_UserDaoTest");
//		sut.addNewEntity(userId);
	}


	@Test
	public void testGet() {
//		sut.getByNaturalId("testuser_UserDaoTest");
	}


	@Test
	public void testDelete() {
//		sut.deleteByNaturalId("testuser_UserDaoTest");
	}
}

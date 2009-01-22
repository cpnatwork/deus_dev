package deus.core.gatekeeper.impl;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deus.core.User;
import deus.core.gatekeeper.Gatekeeper;
import deus.core.gatekeeper.soul.LoginCredentials;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/deus/model/attention/attentionList.xml", "/deus/storage/daos.xml",
		"/deus/core/core.xml", "/deus/context.xml" })
public class InitDestroyGatekeeperDecoratorTest {

	@Resource
	private Gatekeeper gatekeeper;
	
	@Test
	public void testLogin() {
		LoginCredentials credentials = new LoginCredentials();
		credentials.setUsername("username");
		credentials.setPassword("password");
		
		User user = gatekeeper.login(credentials);
	}


	@Test
	public void testLogout() {
		// TODO: implement testLogout()
		//fail("Not yet implemented");
	}

}

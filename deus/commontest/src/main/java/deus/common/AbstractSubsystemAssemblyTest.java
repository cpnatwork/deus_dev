package deus.common;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/all.xml" })
public abstract class AbstractSubsystemAssemblyTest {

	@Autowired
	private ApplicationContext context;

	private String subsystemBasePackage;


	public AbstractSubsystemAssemblyTest() {
		this.subsystemBasePackage = getClass().getPackage().getName().toString();
	}
	
	public AbstractSubsystemAssemblyTest(String subsystemBasePackage) {
		this.subsystemBasePackage = subsystemBasePackage;
	}


	@Test
	public void testIntegration() {
		System.out.println("loaded Spring beans: " + Arrays.toString(context.getBeanDefinitionNames()));


		StringBuilder loadedDomainBeans = new StringBuilder();

		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			Object bean = context.getBean(name);
			if (bean.getClass().getPackage() != null
					&& bean.getClass().getPackage().getName().startsWith(subsystemBasePackage))
				loadedDomainBeans.append(name + ", ");
		}

		int l = loadedDomainBeans.length();
		if (l > 0)
			loadedDomainBeans.delete(l - 2, l);
		System.out.println("loaded domain beans: [" + loadedDomainBeans.toString() + "]");
	}

}

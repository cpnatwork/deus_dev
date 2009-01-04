package inf6.promed.deus;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestClass {

	/*
	 * Spring Annotations:
	 * 
	 * Dependency Injection:
	 * 
	 * @Required
	 * @Autowired
	 * @Resource(name="beanNametoInject") (JSR-250)
	 * 
	 * Initialization/Destruction callbacks:
	 * 
	 * @PostConstruct
	 * @PreDestroy
	 * 
	 * Managed Components:
	 * 
	 * @Component
	 * 	@Controller
	 * 	@Service
	 * 	@Repository
	 */

	@PostConstruct
	public void start() {
		System.out.println("HEEEEELLLOOO WORLD");

		System.out.println(2);
		
		final Logger logger = LoggerFactory.getLogger(TestClass.class);
 		logger.info("test");
	}

	@PreDestroy
	public void stop() {
		System.out.println("GOODBYE WORLD");
	}

}

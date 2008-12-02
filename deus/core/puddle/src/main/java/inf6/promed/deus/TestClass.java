package inf6.promed.deus;

@Component
public class TestClass {
	
	/*
	 * Spring Annotations:
	 * 
	 * Dependency Injection:
	 * 
	 * @Required
	 * @Autowired
	 * @Resource(name="beanNametoInject")  (JSR-250)
	 * 
	 * Initialization/Destruction callbacks:
	 * 
	 * @PostConstruct
	 * @PreDestroy
	 * 
	 * Managed Components:
	 * @Component
	 * 	@Controller
	 *  @Service
	 *  @Repository
	 * 
	 */
	

	public void start() {
		System.out.println("HEEEEELLLOOO WORLD");
	}
	
	public void stop() {
		System.out.println("GOODBYE WORLD");
	}	
	
}

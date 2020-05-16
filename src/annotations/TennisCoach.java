package annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatTennisCoach")
// default bean id = className with lowercase first letter -> tennisCoach
@Component
//@Scope("prototype")
@Scope("singleton")
public class TennisCoach implements Coach {
//	Dependency injection via field
	// Easiest way, spring injects dependency based on the fields
	@Autowired
	@Qualifier("happyFortuneService") // when you have multiple implementations of an interface, you need to use @Qualifier
	// to explicitly say which one to use
	private FortuneService fortuneService;
	
//	Dependency injection via auto wired constructor
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		fortuneService = theFortuneService;
//	}
	
//	Dependency injection via auto wired setter
	
	// default constructor (not required, doing it for additional info)
	public TennisCoach() {
		System.out.println("Inside default constructor - Tennis Coasch");
	}
	
	
	// when spring sees autowired, it will look for a fortune service dependency
	// and automatically inject it via this setter method
	//@Autowired
	// define a setter - this works with any method name as long as it has @Autowired
//	public void setFortuneService(FortuneService theFortuneService) {
//		System.out.println("Inside Setter Method - Tennis Coasch");
//		fortuneService = theFortuneService;
//	}
	
//	@Autowired - method injection (setter w/ an arbitrary method name . . . )
//	public void doStuffLol(FortuneService theFortuneService) {
//		System.out.println("Inside Setter Method - Tennis Coasch");
//		fortuneService = theFortuneService;
//	}
	
	
	
	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("Tennis Coach - inside start up stuff");
	}
	
	// define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("Tennis Coach - inside clean up stuff");
	}
	
	

	@Override
	public String getDailyWorkout() {
		return "Practice that BACK HAND!!!!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

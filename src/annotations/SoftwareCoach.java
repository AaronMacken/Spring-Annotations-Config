package annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("javaCoach")
public class SoftwareCoach implements Coach {
	
	@Autowired
	@Qualifier("sadFortuneService")
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "Implement Java Annotations";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

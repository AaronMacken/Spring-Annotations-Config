package annotations;

import org.springframework.stereotype.Component;

// @Component so Spring can register this as a bean on runtime
@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is a good day";
	}

}

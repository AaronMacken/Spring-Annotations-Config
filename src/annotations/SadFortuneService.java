package annotations;

import java.util.Random;

import org.springframework.stereotype.Component;

// add @Component for auto scanning of spring config
@Component
public class SadFortuneService implements FortuneService {
	
	// create an array of strings
	private String[] data = {
			"Dusty . . .", 
			"Whack . . .",
			"Bummer . . ."
	};
	
	// create random number generator
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		// prick a random string from array
		int index = myRandom.nextInt(data.length);
		
		String theFortune = data[index];
		return theFortune;
	}

}

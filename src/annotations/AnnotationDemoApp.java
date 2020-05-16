package annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach javaCoach = context.getBean("javaCoach", Coach.class);
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(javaCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(javaCoach.getDailyFortune());
		// close the container
		context.close();
	}

}

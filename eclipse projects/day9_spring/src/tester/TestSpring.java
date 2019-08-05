package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring-config.xml")) {
			System.out.println("SC started .....");
			ATMImpl ref1 = ctx.getBean("my_atm",ATMImpl.class);
			ref1.deposit(1000);
			ATMImpl ref2 = ctx.getBean("my_atm",ATMImpl.class);
			System.out.println(ref1 == ref2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

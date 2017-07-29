package main;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;

public class TestClass{

	@Test
	public void test() {
		Subject s = new Subject();
		Logger.start();
		
		s.act();
		
		Logger.stop();
		List<String> logs = Logger.getLogs();
		logs.forEach((log)->System.out.println(log));
		assertNotNull(logs.get(0));
	}
	
	class Subject{
		void act() {
			
		}
	}

}

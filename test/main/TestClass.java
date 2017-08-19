package main;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;
import java.util.function.Consumer;

import org.junit.*;

import otherPackage.ClassWithDependencies;
public class TestClass{

	@Test
	public void test() {
		Subject s = new Subject();
		Logger.start();
		
		s.act();
		
		Logger.stop();
		List<String> logs = Logger.getLogs();
		logs.forEach(new Consumer<String>() {
			public void accept(String log) {
				System.out.println(log);
			}
		});
		assertNotNull(logs.get(0));
	}
	
	@Test
	public void dependencyIsOk() {
		FileDiagram fd = new FileDiagram(Diagram.getInstance(), new File(""));
		assertNotNull(fd);
		System.out.println("object "+fd.toString()+"  is ok!");
	}
	
	@Test
	public void classWithDependenciesIsOk() {
		ClassWithDependencies cwd = new ClassWithDependencies();
		assertNotNull(cwd);
		System.out.println("object "+cwd.toString()+"  is ok!");
	}
	class Subject{
		void act() {
			
		}
	}

}

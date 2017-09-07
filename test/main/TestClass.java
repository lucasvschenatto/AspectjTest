package main;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

import org.junit.*;

import otherPackage.ClassWithDependencies;
public class TestClass{

	@Test
	public void test() {
		Subject s = new Subject();
		Controller.start();
		
		s.act();
		
		Controller.stop();
		List<String> logs = Controller.getLogs();
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
	
	@Test
	public void testFileReading() throws Exception{
		File folder = new File("docs");
		folder.mkdirs();
		File f = new File("docs/dummyFile.txt");
		FileWriter fw = new FileWriter(f);
		fw.write("###############################------------------##################################"
				+ "\n"
				+ "huhuhu, the file writing works well!"
				+ "\n"
				+ "##############################------------------##################################");
		fw.close();
	}
	
	class Subject{
		void act() {
			
		}
	}

}

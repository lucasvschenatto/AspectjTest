package otherPackage;

import main.Controller;

public class ClassWithDependencies {
	public ClassWithDependencies() {
		Controller.start();
		Controller.stop();
	}
}

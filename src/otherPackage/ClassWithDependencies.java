package otherPackage;

import main.Logger;

public class ClassWithDependencies {
	public ClassWithDependencies() {
		Logger.start();
		Logger.stop();
	}
}

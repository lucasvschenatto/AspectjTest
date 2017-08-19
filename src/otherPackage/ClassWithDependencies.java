package otherPackage;

import main.LoggerAdapter;

public class ClassWithDependencies {
	public ClassWithDependencies() {
		LoggerAdapter.start();
		LoggerAdapter.stop();
	}
}

package main;

import java.util.List;

public class LoggerAdapter{
	public static void start() {
		Logger.start();
	}
	public static void stop() {
		Logger.stop();
	}
	public static List<String> getLogs() {
		return Logger.getLogs();
	}
}

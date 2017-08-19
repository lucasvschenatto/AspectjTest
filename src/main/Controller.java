package main;

import java.util.ArrayList;
import java.util.List;

public class Controller {
	public static void start(){
		Context.RUNNING = true;
		Context.LOGS = new ArrayList<String>();
	}
	public static void stop(){
		Context.RUNNING = false;
	}
	public static List<String> getLogs() {
		return Context.LOGS;
	}
}

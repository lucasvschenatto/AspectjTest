package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.aspectj.lang.Signature;


public aspect Logger{
	private static List<String> logs;
	private static boolean running;
	
	pointcut immune():if(running)
		&&!call(java*..new(..))
		&&!execution(java*..new(..))
		&&!initialization(java*..new(..))
		&&!preinitialization(java*..new(..))
		&&!call(* java*..*(..))
		&&!execution(* java*..*(..))
		&&!within(java*..*)
		&& !within(Logger+);
	
	pointcut methodExecution():
		execution(* *.*(..))&&immune();
	
	before():methodExecution(){
		Signature s = thisJoinPointStaticPart.getSignature();
		String className = s.getDeclaringType().getCanonicalName();
		String methodName = s.getName();
		logs.add("Class:\t"+className+"\nMethod:\t"+methodName);
	}
	
	public static void start(){
		running = true;
		logs = new ArrayList<String>();
	}
	public static void stop(){
		running = false;
	}
	public static List<String> getLogs() {
		return logs;
	}
}
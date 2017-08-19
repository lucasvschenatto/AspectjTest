package main;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.Signature;


public aspect Logger{
	
	pointcut immune():if(Context.RUNNING)
		&&!call(java*..new(..))
		&&!execution(java*..new(..))
		&&!initialization(java*..new(..))
		&&!preinitialization(java*..new(..))
		&&!call(* java*..*(..))
		&&!execution(* java*..*(..))
		&&!within(java*..*)
		&& !within(Logger+)
		&& !within(Controller+);
	
	pointcut methodExecution():
		execution(* *.*(..))&&immune();
	
	before():methodExecution(){
		Signature s = thisJoinPointStaticPart.getSignature();
		String className = s.getDeclaringType().getCanonicalName();
		String methodName = s.getName();
		Context.LOGS.add("Class:\t"+className+"\nMethod:\t"+methodName);
	}
}
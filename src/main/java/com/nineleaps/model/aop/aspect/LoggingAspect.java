package com.nineleaps.model.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect // configure with xml config file
public class LoggingAspect {

//	@Before(value = "execution(public String com.nineleaps.model.Circle.getName())")
//	@Before(value = "execution(public * get*())")
//	@Before(value = "execution(* get*())")
//	@Before(value = "execution(* com.nineleaps.model.*.get*(..))") 
//	@Before(value = "execution(* get*(..))") //zero or more argument
//	@Before("allGetters()")
//	@Before("allGetters() || allCircleMethods()") // Good Practice
//	@Before("allGetters() && allCircleMethods()")
//	public void loggingAdvice()
//	{
//		System.out.println("Advice run. Get method called.");
//	}

//	@Before("allCircleMethods()")
//	public void loggingAdvice(JoinPoint joinpoint) //JoinPoint all the possible places in u code where can we applied in Advice
//	{
//		System.out.println(joinpoint.toString());
//		System.out.println(joinpoint.getTarget());
//		Circle circle = (Circle) joinpoint.getTarget();
//		System.out.println(circle);
//	}
	
//	@Before(value = "args(String)")
//	public void stringArgumentMethods()
//	{
//		System.out.println("A method that takes String arguments has been called");
//	}
	
//	@Before(value = "args(name)")
//	public void stringArgumentMethods(String name)
//	{
//		System.out.println("A method that takes String arguments has been called: The value is: "+name);
//	}
	
//	@After(value = "args(name)")
//	public void stringArgumentMethods(String name)
//	{
//		System.out.println("A method that takes String arguments has been called: The value is: "+name);
//	}
	
//	@AfterReturning(value = "args(name)")
//	public void stringArgumentMethods(String name)
//	{
//		System.out.println("A method that takes String arguments has been called: The value is: "+name);
//	}
//	@AfterReturning(pointcut = "args(name)", returning = "returnString") //returnString return type needed
//	public void stringArgumentMethods(String name, String returnString)
//	public void stringArgumentMethods(String name, Object returnString)
//	{
//		System.out.println("A method that takes String arguments has been called: The value is: "+name + " The output value is: "+returnString);
//	}

//	@AfterThrowing(value = "args(name)")
//	public void exceptionAdvice(String name)
//	@AfterThrowing(pointcut = "args(name)", throwing = "ex")
//	public void exceptionAdvice(String name, RuntimeException ex)
//	{
//		System.out.println("An exception has been thrown. "+ex.getMessage());
//	}
	
//	@Around(value = "allGetters()")
//	@Around(value = "@annotation(com.nineleaps.aspect.Loggable)")
//	@Around(value = "allGetters()") //configure the xml file
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) //ProceedingJoinPoint mendatory arug
	{
		//any time - when actual method called target method happened
		Object returnProceedValue = null;
		try 
		{
			System.out.println("Before Advice");
			returnProceedValue = proceedingJoinPoint.proceed();
			System.out.println("After the Reteurning");
		} catch (Throwable e) {
			System.out.println("After throwing");
		}
//		finally
//		{
//			System.out.println("finally block");
//		}
		System.out.println("After Finally");
		
		return returnProceedValue;
	}

	
	
//	@Pointcut(value = "execution(* com.nineleaps.service.*Service.*(..))")
//	public void callOnlyForServiceClassMethod() {}
	
	
//	@Before(value = "execution(* get*())")
//	@Before("allGetters()") // all getters in class 
//	public void secondAdvice()
//	{
//		System.out.println("Second Advice executed.");
//	}
	
//	@Pointcut(value = "execution(* get*())") //configure this xml file
	public void allGetters() {}
	
//	@Pointcut(value = "execution(* * com.nineleaps.model.Circle.*(..))")
//	@Pointcut("within(com.nineleaps.model.*)") //allpied the class inside the package
//	@Pointcut("within(com.nineleaps.model..*)")  //can be alllied in sub package the class inside the package
//	@Pointcut("within(com.nineleaps.model.Circle)")
//	public void allCircleMethods() {}
//	
//	@Pointcut(args()) // check in spring apo doc for more details.
	
	
	public void loggingAdvice()
	{
		System.out.println("Logginf from the Advice");
	}
}

package mypackage.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import mypackage.model.Circle;
import mypackage.model.Triangle;
import mypackage.service.ShapeService;

// Below Component Bean Annotation commented as this aspect is only for reference purpose and should not be
// instantiated as a bean
// @Component
@Aspect
public class LoggingAspectRef
{

	// Class specific any get method with String return type - Specific public method that starts with get
	// and takes no argument as parameter
	@Before("execution(public String mypackage.model.Circle.get*())")
	public void LoggingAdvice_Class()
	{
		System.out.println("Class and Method specific Logging Advice Executed! Get Method Called.");
	}

	// Package specific with any return type - any public method that starts with get and takes no
	// argument as parameter
	@Before("execution(public * mypackage.model.*.get*())")
	public void LoggingAdvice_Package()
	{
		System.out.println("Package Specific Logging Advice Executed! No return type - No Args Get Method Called.");
	}

	// Package specific with any return type - any public/private/protected method that starts with get
	// and takes 0 or more argument as parameter
	@Before("execution( * mypackage.model.*.get*(..))")
	public void LoggingAdvice_No_Any_Args()
	{
		System.out.println("Package Specific Logging Advice Executed! Get Method Called. 0 or more Args of any type");
	}

	// No Package specific with any return type - any public method that starts with get and takes 0 or more
	// argument as parameter
	@Before("execution(public * get*(..))")
	public void LoggingAdvice()
	{
		System.out.println("Logging Advice Executed! Get Method Called. Generic");
	}

	@Before("All_circle_Methods()")
	public void Logging_Advice2()
	{
		System.out.println("Logging advice 2 called on all methods of Circle");
	}

	@Before("All_triangle_Methods()")
	public void Logging_Advice3()
	{
		System.out.println("Logging advice 3 called on all methods of Triangle");
	}

	@Pointcut("execution(public * mypackage.service.*.get*(..))")
	public void all_Getters_Service()
	{

	}

	@Pointcut("within(mypackage.model.Circle)")
	public void All_circle_Methods()
	{

	}

	@Pointcut("within(mypackage.model.Triangle)")
	public void All_triangle_Methods()
	{

	}

	// Logging Advice which intercepts and acts upon the invoking Object in JoinPoint
	@Before("All_circle_Methods()")
	public void Logging_Advice1(JoinPoint joinpoint)
	{
		if (joinpoint != null)
		{
			Object shape = joinpoint.getTarget();
			if (shape != null)
			{
				if (shape instanceof ShapeService)
				{
					System.out.println("Logging for ShapeService");
				}

				if (shape instanceof Circle)
				{
					System.out.println("Logging for Circle");
				}
				if (shape instanceof Triangle)
				{
					System.out.println("Logging for Triangle");
				}
			}
		}
	}
}

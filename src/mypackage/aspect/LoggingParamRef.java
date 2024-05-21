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
public class LoggingParamRef
	{
		/*
		 * @Before("args(name)") public void all_Setters_that_take_StringParam_Advice(String name) {
		 * System.out.println("String Argument value is " + name); }
		 */
		
		@Before("All_Setters_Model() && args(name)")
		public void Logging_Setters(JoinPoint jp, String name)
			{
				if (jp != null)
					{
						Object shape = jp.getTarget();
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
				System.out.println("Setters Call");
				System.out.println("Method takes a String Argument with value " + name);
			}
			
		/*
		 * @Before("args(name)") public void args_String(String name) { System.out.println(
		 * "Method takes a String Argument with value " + name); }
		 */
		
		@Pointcut("execution(* mypackage.model.*.set*(*))")
		
		public void All_Setters_Model()
			{
				
			}
	}

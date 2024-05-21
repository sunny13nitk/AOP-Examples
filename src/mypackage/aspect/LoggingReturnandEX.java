package mypackage.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingReturnandEX
	{
		@Pointcut("within(mypackage.model..*)")
		public void Model_Package_Methods()
			{
				
			}
			
		@AfterReturning(pointcut = "args(name) && Model_Package_Methods()", returning = "retString")
		public void After_Setters(String name, Object retString)
			{
				System.out.println("Called after Setter with parameter " + name);
				System.out.println("Value Returned after Setting" + retString);
			}
			
		@AfterThrowing(pointcut = "args(name) && Model_Package_Methods()", throwing = "Ex")
		public void Exxception_Handling(String name, Exception Ex)
			{
				System.out.println("Exception fired! " + name);
				System.out.println(Ex.getMessage());
			}
	}

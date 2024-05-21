package mypackage.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import mypackage.model.Circle;
import mypackage.model.Triangle;
import mypackage.service.ShapeService;

// Below Component Bean Annotation commented as this aspect is only for reference purpose and should not be
// instantiated as a bean
//@Component
@Aspect
public class LoggingParamTargetRef implements ApplicationContextAware
	{
		
		private ShapeService shapeService;
		
		public ShapeService getShapeService()
			{
				return shapeService;
			}
			
		@Before("All_Setters_Model() && args(name) && target(mypackage.model.Circle)")
		public void Logging_Setters(JoinPoint jp, Object name)
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
									
								System.out.println("************Join Point Details ****************");
								System.out.println(
								      "Signature -  " + jp.getSignature() + "Kind -  " + jp.getKind() + "Class Name - " + jp.getClass().getSimpleName()
								            + "Source Location -  " + jp.getSourceLocation() + "Static Part - " + jp.getStaticPart());
								Object[] args = jp.getArgs();
								for (Object object : args)
									{
										System.out.println(object.toString());
									}
							}
					}
					
				System.out.println("Setters Call");
				System.out.println("Method takes a" + name.getClass().getSimpleName() + "Argument with value " + name);
			}
			
		@Pointcut("execution(* mypackage.model.*.set*(*))")
		
		public void All_Setters_Model()
			{
				
			}
			
		@Override
		public void setApplicationContext(ApplicationContext context) throws BeansException
			{
				this.shapeService = (ShapeService) context.getBean("shapeService");
				if (this.shapeService != null)
					{
						System.out.println("Shape Service context populated");
					}
			}
			
	}

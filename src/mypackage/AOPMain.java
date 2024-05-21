package mypackage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mypackage.interfaces.ExecutableService;
import mypackage.managers.AbstractServiceManager;
import mypackage.model.CircleService;

public class AOPMain
	{
		
		public static void main(String[] args)
			{
				ApplicationContext ctxt = new ClassPathXmlApplicationContext("spring.xml");
				
				// ServiceManager srvManager = (ServiceManager) ctxt.getBean("ServiceManager");
				
				// if (srvManager != null)
				// {
				
				// Version 1 - Generic Executable Service Interface
				ExecutableService circleSrv = (CircleService) AbstractServiceManager.getService("CircleService");
				if (circleSrv != null)
					{
						circleSrv.initializeService(new Object[]
							{ 10.0 });
						System.out.println(circleSrv.executeService());
					}
					
				// Version 2 - Specific Circle Service Interface
				CircleService circleSrv2 = (CircleService) AbstractServiceManager.getService("CircleService");
				if (circleSrv2 != null)
					{
						circleSrv2.setRadius(10);
						System.out.println(circleSrv2.Calculate_Area());
					}
					
				// }
				
			}
			
		public void uncomment()
			{
				/*
				 * ShapeService shapeService = ctxt.getBean("shapeService", ShapeService.class);
				 * System.out.println(shapeService.getCircle().getName());
				 * Circle circle = shapeService.getCircle();
				 * circle.setName("Dummy Circle");
				 * System.out.println(shapeService.getCircle().getName());
				 */
				/*
				 * CircleNameSetter circle2 = new CircleNameSetter(); circle2.setName("test sess name");
				 * System.out.println(circle2.getName());
				 */
				
				/*
				 * circle.SetName_from_Session(); System.out.println(shapeService.getCircle().getName());
				 * System.out.println(shapeService.getTriangle().getName()); Triangle triangle =
				 * shapeService.getTriangle(); triangle.setNameandreturn("Dummy Triangle"); triangle.setName(
				 * "Test Exception Triangle");
				 */
				
				/*
				 * INamesetter circle2 = (INamesetter) ctxt.getBean("circleNameSetter"); if (circle2 != null)
				 * { circle2.SetName_from_Session(); }
				 */
				/*
				 * circle2.setName("Test Circle"); System.out.println(circle2.getName());
				 * circle2.SetName_from_Session(); System.out.println(circle2.getName());
				 */
			}
			
	}

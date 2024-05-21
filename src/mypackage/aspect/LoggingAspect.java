package mypackage.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

import mypackage.model.Circle;
import mypackage.model.CircleNameSetter;
import mypackage.model.namesetter;

/*@Component
@Aspect*/
public class LoggingAspect
	{
		@Autowired
		private namesetter SessionNameSetter;
		
		public namesetter getSessionNameSetter()
			{
				return SessionNameSetter;
			}
			
		@Before("execution( public * mypackage.model.*.SetName_from_Session())")
		public void Set_Name_using_Session(JoinPoint jp)
			{
				if (jp != null)
					{
						Object obj = jp.getTarget();
						if (obj instanceof Circle)
							{
								Circle circle = (Circle) obj;
								circle.setName(this.getSessionNameSetter().getName());
								System.out.println(circle.getName());
							}
						if (obj instanceof CircleNameSetter)
							{
								CircleNameSetter circle2 = (CircleNameSetter) obj;
								circle2.setName(this.getSessionNameSetter().getName());
								System.out.println(circle2.getName());
							}
					}
			}
			
	}

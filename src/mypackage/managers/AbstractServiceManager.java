/**
 * 
 */
package mypackage.managers;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * 
 * Abstract ServiceManager
 */
@Service("AbsServiceManager")
public class AbstractServiceManager implements ApplicationContextAware
	{
		
		private static ApplicationContext Context;
		
		public static mypackage.interfaces.Service getService(String serviceName)
			{
				mypackage.interfaces.Service retService = null;
				
				if (Context != null && serviceName != null)
					{
						retService = (mypackage.interfaces.Service) Context.getBean(serviceName);
					}
					
				return retService;
			}
			
		/*
		 * (non-Javadoc)
		 * @see
		 * org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context
		 * .ApplicationContext)
		 */
		@Override
		public void setApplicationContext(ApplicationContext ctxt) throws BeansException
			{
				Context = ctxt;
				
			}
			
	}

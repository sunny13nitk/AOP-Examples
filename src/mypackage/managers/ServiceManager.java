/**
 * 
 */
package mypackage.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 
 * Returns beans of specific type(s) that implement Service Interface
 */
@Service("ServiceManager")
public class ServiceManager// implements ApplicationContextAware
	{
		@Autowired
		private ApplicationContext Context;
		
		public ServiceManager()
			{
				
			}
			
		public mypackage.interfaces.Service getService(String serviceName)
			{
				mypackage.interfaces.Service retService = null;
				
				if (this.Context != null && serviceName != null)
					{
						retService = (mypackage.interfaces.Service) this.Context.getBean(serviceName);
					}
					
				return retService;
			}
			
		/*
		 * (non-Javadoc)
		 * @see
		 * org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context
		 * .ApplicationContext)
		 */
		/*
		 * @Override
		 * public void setApplicationContext(ApplicationContext ctxt) throws BeansException
		 * {
		 * this.Context = ctxt;
		 * }
		 */
	}

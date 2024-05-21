/**
 * 
 */
package mypackage.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import mypackage.interfaces.ExecutableService;
import mypackage.interfaces.Service;

/**
 * Implments Service so bean can be returned via Abstract Service manager
 * Implements Executable Service so it can be called using common Architecture
 * of Executable Service
 */
@Component("CircleService")

public class CircleService implements Service, ExecutableService
	{
		
		public double radius;
		
		/**
		 * @return the radius
		 */
		public double getRadius()
			{
				return radius;
			}
			
		/**
		 * @param radius
		 *           the radius to set
		 */
		public void setRadius(double radius)
			{
				this.radius = radius;
			}
			
		public double Calculate_Area()
			{
				double area = 0;
				
				area = 3.14 * radius * radius;
				
				return area;
			}
			
		/*
		 * (non-Javadoc)
		 * @see mypackage.interfaces.Service#initializeService()
		 */
		@Override
		public void initializeService(Object[] args)
			{
				this.setRadius((double) args[0]);
				
			}
			
		/*
		 * (non-Javadoc)
		 * @see mypackage.interfaces.Service#validateService()
		 */
		@Override
		public boolean validateService()
			{
				if (getRadius() <= 0)
					{
						return false;
					}
				else
					{
						return true;
					}
			}
			
		/*
		 * (non-Javadoc)
		 * @see mypackage.interfaces.Service#executeService()
		 */
		@Override
		public ArrayList<Object> executeService()
			{
				ArrayList<Object> retArgs = new ArrayList<Object>();
				if (validateService() == true)
					{
						retArgs.add(Calculate_Area());
					}
					
				return retArgs;
				
			}
			
	}

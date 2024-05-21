/**
 * 
 */
package mypackage.interfaces;

import java.util.ArrayList;

/**
 * 
 *
 */
public interface ExecutableService
	{
		public void initializeService(Object[] args);
		
		public boolean validateService();
		
		public ArrayList<Object> executeService();
		
	}

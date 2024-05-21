package mypackage.model;

import org.springframework.stereotype.Component;

@Component
public class CircleNameSetter implements INamesetter
	{
		private String Name;
		
		public String getName()
			{
				return Name;
			}
			
		public void setName(String name)
			{
				Name = name;
				System.out.println("Setter Called!");
				SetName_from_Session();
			}
			
		public void SetName_from_Session()
			{
				
			}
	}

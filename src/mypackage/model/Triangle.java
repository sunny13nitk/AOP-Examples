package mypackage.model;

public class Triangle
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
				
			}
			
		public String setNameandreturn(String name)
			{
				Name = name;
				System.out.println("Setter Called!");
				return Name;
			}
			
	}
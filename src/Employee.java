
public class Employee {
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", address=" + address + "]";
	}

	private String name;
	private int id;
	private String address;
	
	
	public String getName() {
		return name;
	}

	

	public int getId() {
		return id;
	}

	

	public String getAddress() {
		return address;
	}

	
	public Employee(String name, int id, String address) {
		super();
		this.name = name;
		this.id = id;
		this.address = address;
	}


	private static class A{
		public  First run(int a) {
			return new First();
		}
	}
	
	private static class First{
		
	}
	
	private static class Second extends First{
		
	}
	
	private static class B extends A{
		public  Second run(int b) {
			System.out.print(b+"");
			return new Second();
		}
	}
	
	public static void main(String[] args) {
		//A a  = new B();
		
		//System.out.println(a.run(10).getClass().getSimpleName());
		 char last_removed = '\0'; 
		System.out.println(removeUtil("cabbaaabcc", last_removed));
	}
	
	 static String removeUtil(String str, char last_removed) 
     { 
            // If length of string is 1 or 0  
            if (str.length() == 0 || str.length() == 1) 
                return str; 
 
            // Remove leftmost same characters and recur for remaining   
            // string  
            if (str.charAt(0) == str.charAt(1)) 
            { 
                last_removed = str.charAt(0); 
                while (str.length() > 1 && str.charAt(0) == str.charAt(1)) 
                      str = str.substring(1, str.length()); 
                str = str.substring(1, str.length()); 
                return removeUtil(str, last_removed);  
            } 
 
            // At this point, the first character is definiotely different   
            // from its adjacent. Ignore first character and recursively   
            // remove characters from remaining string  
            String rem_str = removeUtil(str.substring(1,str.length()), last_removed); 
 
            // Check if the first character of the rem_string matches with   
            // the first character of the original string 
            if (rem_str.length() != 0 && rem_str.charAt(0) == str.charAt(0)) 
            { 
               last_removed = str.charAt(0); 
               return rem_str.substring(1,rem_str.length()); // Remove first character 
            }  
 
 
            // If remaining string becomes empty and last removed character  
            // is same as first character of original string. This is needed  
            // for a string like "acbbcddc"  
            if (rem_str.length() == 0 && last_removed == str.charAt(0)) 
                return rem_str; 
 
            // If the two first characters of str and rem_str don't match,   
            // append first character of str before the first character of  
            // rem_str 
            return (str.charAt(0) + rem_str); 
     } 
	
}

package m;
import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;
import java.util.Map;
import java.util.Scanner;  

public class Client {  
   private Client() {}  
   public static void main(String[] args) {  
	   Scanner cin = new Scanner(System.in);
      try {  
         // Getting the registry 
         Registry registry = LocateRegistry.getRegistry(null); 
    
         // Looking up the registry for the remote object 
         Executor stub = (Executor) registry.lookup("Hello"); 
         
         do{
         System.out.print("SQL> ");
         String q = cin.nextLine();
         // Calling the remote method using the obtained object 
         Bean bean = stub.execute(q);
         
          
         for(int i=0; i<bean.tuples.size(); i++)
	 		for(Map.Entry<String,String> m:bean.tuples.get(i).entrySet()){  
	 			   System.out.println(m.getKey()+" "+m.getValue());  
	 	    } 
 		
          System.out.println("Remote method invoked: "); 
          
         }while(true);
      } catch (Exception e) {
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}
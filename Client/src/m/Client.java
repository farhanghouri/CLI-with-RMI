package m;
import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;
import java.util.Map;  

public class Client {  
   private Client() {}  
   public static void main(String[] args) {  
      try {  
         // Getting the registry 
         Registry registry = LocateRegistry.getRegistry(null); 
    
         // Looking up the registry for the remote object 
         Executor stub = (Executor) registry.lookup("Hello"); 
    
         // Calling the remote method using the obtained object 
         Bean bean = stub.execute("select * from employee");
         

 		for(Map.Entry m:bean.tuples.get(0).entrySet()){  
 			   System.out.println(m.getKey()+" "+m.getValue());  
 			  } 
 		
          System.out.println("Remote method invoked: "); 
      } catch (Exception e) {
         System.err.println("Client exception: " + e.toString()); 
         e.printStackTrace(); 
      } 
   } 
}
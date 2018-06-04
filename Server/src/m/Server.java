 
package m;
 
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject; 

public class Server{
	  
	public static void main(String[] args){
		
		 try{
			 ExecutorImplementation executorImplementation = new ExecutorImplementation();

	         // Exporting the object of implementation class  
	         // (here we are exporting the remote object to the stub) 
	         Executor stub = (Executor) UnicastRemoteObject.exportObject(executorImplementation, 0);  
	         
	         // Binding the remote object (stub) in the registry 
	         Registry registry = LocateRegistry.getRegistry(); 
	         
	         registry.bind("Hello", stub);  
	         System.err.println("Server ready..."); 
		 }
		 catch(Exception ex){
			 System.out.println(ex);
		 }
	 
	}

}

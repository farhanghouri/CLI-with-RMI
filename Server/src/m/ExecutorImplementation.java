package m;

import java.rmi.RemoteException; 

public class ExecutorImplementation implements Executor {

	@Override
	public Bean execute(String cmd) throws RemoteException {
		/***************
		 * use singleton pattern,command pattern
		 * use connection pooling
		 * use custom connection
		 */
		    
	        boolean flag = false;
	        QueryReceiver queryRecevier = new MySQLQueryReceiver();
		    Command command = null;
		   
		  
	        String query = cmd; 
		    System.out.println("SQL> "+query);
	           
	        switch ((query.contains(" ") ? query.split(" ")[0] : query).toLowerCase()) {
			case "select":
				command = new SelectQueryCommand(queryRecevier);
				break;
			case "update":
				command = new UpdateQueryCommand(queryRecevier);
				break; 
			case "delete":
				command = new DeleteQueryCommand(queryRecevier);
				break;
			case "insert":
				command = new InsertQueryCommand(queryRecevier);
				break;
			default:
				flag = true;
				System.out.println("invalid input.");
				break;
			}

	        
	        if(!flag){
		        QueryInvoker queryInvoker = new QueryInvoker(command);
		        return queryInvoker.execute(query);
	        }
	        return new Bean();
	        
		     
		
	}
    
}

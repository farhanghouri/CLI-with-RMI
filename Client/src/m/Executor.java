package m;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Executor extends Remote{ 
	public Bean execute(String cmd) throws RemoteException;
}

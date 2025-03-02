package perClient;

import java.rmi.Remote;
import java.rmi.RemoteException;

// This method provides the remote interface to create a service
// We can utilize this to create a service per client
public interface MathServiceFactory extends Remote {
    // Method to create a MathService object for the client
    // Used to perform the calculations remotely.
    MathService createMathService() throws RemoteException;

    // Method to retrieve the current client count by the clients if necessary.
    // Does not allow the clients to edit the clientCount variable.
    // Security is maintained.
    int getClientCount() throws RemoteException;
}

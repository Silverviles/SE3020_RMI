package perClient;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MathServerFactory extends UnicastRemoteObject implements MathServiceFactory {
    // Make the variable volatile as it exists in many threads and
    // are monitored in many threads.
    private volatile int clientCount = 0;

    // Move the increment method to the server factory as the server is
    // created by the factory for each client.
    // Therefore the server cannot accurately keep track of the client count.
    private synchronized void incrementClientCount() {
        clientCount++;
        System.out.println ("client count is now " + clientCount);
    }

    public int getClientCount() throws RemoteException{
        return clientCount;
    }

    public MathServerFactory() throws RemoteException {
        super();
    }

    @Override
    public MathService createMathService() throws RemoteException {
        incrementClientCount();
        return new MathServiceImpl();
    }

    public static void main(String[] args) {
        try {
            MathServerFactory svr = new MathServerFactory();

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("ServiceFactory", svr);

            System.out.println("Service started....");
        } catch (RemoteException re) {
            System.err.println(re.getMessage());
        } catch (AlreadyBoundException re) {
            System.err.println(re.getMessage());
        }
    }
}

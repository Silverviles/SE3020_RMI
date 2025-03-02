package original;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MathServer extends UnicastRemoteObject implements MathService {

    // TODO: Add a private variable to keep the client count
    private int clientCount = 0;

    public MathServer() throws RemoteException {
        super();
    }

    // TODO: add a method to increment the client count. Make it thread safe
    public synchronized int incrementClientCount() {
        clientCount++;
        System.out.println ("client count is now " + clientCount);
        return clientCount;
    }

    public int add(int a, int b) throws RemoteException {
        System.out.println("Adding " + a + " and " + b + " in the Server");
        return a + b;
    }

    public int subtract(int a, int b) throws RemoteException {
        System.out.println("Substracting " + a + " and " + b + " in the Server");
        return a - b;
    }

    public int multiply(int a, int b) throws RemoteException {
        System.out.println("Multiplying " + a + " and " + b + " in the Server");
        return a * b;
    }

    // this method is not remotely accessible as it's not in the remote interface
    public int test(int a) {
        System.out.println("this is a test");
        return 0;
    }

    public int divide(int a, int b) throws RemoteException, InterruptedException {
        System.out.println("Dividing " + a + " and " + b + " in the Server");

        // sleep for 5 second to simulate a long-running operation.
        // Removed the loop as it makes my computer crash sometimes.
		Thread.sleep(5000);

        return a / b; // check for division with zero here!
    }

    public static void main(String[] args) {

        // set the policy file as the system security policy
        System.setProperty("java.security.policy", "file:allowall.policy");

        try {

            MathServer svr = new MathServer();
            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("CalculatorService", svr);

            System.out.println("Service started....");
        } catch (RemoteException re) {
            System.err.println(re.getMessage());
        } catch (AlreadyBoundException abe) {
            System.err.println(abe.getMessage());
        }
    }
}

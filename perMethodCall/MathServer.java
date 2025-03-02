package perMethodCall;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MathServer extends UnicastRemoteObject implements MathService {
    protected MathServer() throws RemoteException {
        super();
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
}

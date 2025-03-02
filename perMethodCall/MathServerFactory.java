package perMethodCall;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MathServerFactory extends UnicastRemoteObject implements MathServiceFactory {
    public MathServerFactory() throws RemoteException {
        super();
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

    @Override
    public int add(int a, int b) throws RemoteException {
        return new MathServer().add(a, b);
    }

    @Override
    public int subtract(int a, int b) throws RemoteException {
        return new MathServer().subtract(a, b);
    }

    @Override
    public int multiply(int a, int b) throws RemoteException {
        return new MathServer().multiply(a, b);
    }

    @Override
    public int divide(int a, int b) throws RemoteException, InterruptedException {
        return new MathServer().divide(a, b);
    }
}

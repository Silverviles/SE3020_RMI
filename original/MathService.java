package original;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MathService extends Remote {
    int add(int a, int b) throws RemoteException;
    int subtract(int a, int b) throws RemoteException;
    int multiply(int a, int b) throws RemoteException;
    int divide(int a, int b) throws RemoteException, InterruptedException;
    int incrementClientCount() throws RemoteException;
}

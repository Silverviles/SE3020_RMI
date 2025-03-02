package original;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MathClient {
    public static void main(String[] args){
      System.setProperty("java.security.policy", "file:allowall.policy");

        MathService service;
        try {
            service = (MathService) Naming.lookup("//localhost/CalculatorService");

            System.out.println("Current Client Number: " + service.incrementClientCount());
            System.out.println  ("Add : " + service.add(2,2));
            System.out.println  ("Subtract : " + service.subtract(5,2));
            System.out.println  ("Multiply : " + service.multiply(2,6));

            System.out.println  ("Divide : " +  service.divide(4,2));

        } catch (NotBoundException ex) {
            System.err.println(ex.getMessage());
        } catch (MalformedURLException ex) {
            System.err.println(ex.getMessage());
        } catch (RemoteException ex) {
            System.err.println(ex.getMessage());
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}

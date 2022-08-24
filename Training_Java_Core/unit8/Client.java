import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client implements Hello {
    @Override
    public String say(String name) throws RemoteException {
        return null;
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 8080);
        Hello stub = (Hello) registry.lookup("Hello");
        System.out.println("response:" + stub.say(args[0]));
    }
}

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        // 1. Create an object and wrap inside RMI security Manager.
        // 2. Register the object to RMI registry
        // 3. Start the Rmi Server
        // 4. Listen to the particular port for client request.

        try {

            System.out.println("Server is booting now");
            System.out.println("Create product object");

            // Now create an product object which will be
            // ultimately access by client.

            ProductImpl p1 = new ProductImpl("Laptop", "i5 core", 78000);
            ProductImpl p2 = new ProductImpl("mobile", "xiaomi", 45000);
            ProductImpl p3 = new ProductImpl("tab", "i5 core", 58000);
            ProductImpl p4 = new ProductImpl("bag", "i5school bag", 1200);

            // Export all p1 p2 p3 p4 object before registred in registry

            Product stub1 = (Product) UnicastRemoteObject.exportObject(p1, 0);
            Product stub2 = (Product) UnicastRemoteObject.exportObject(p2, 0);
            Product stub3 = (Product) UnicastRemoteObject.exportObject(p3, 0);
            Product stub4 = (Product) UnicastRemoteObject.exportObject(p4, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();

            registry.bind("Laptop", stub1);
            registry.bind("mobile", stub2);
            registry.bind("tab", stub3);
            registry.bind("bag", stub4);

            System.err.println("Server ready");

        } catch (Exception m) {
            System.out.println("Some server error occoured" + m);
        }
    }
}
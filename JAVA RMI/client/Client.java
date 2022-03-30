import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {

        // Reference the exported remote objects in the server
        // by looking up in the RMI registry.

        try {

            Registry registry = LocateRegistry.getRegistry("127.0.0.1");

            // Lookup the laptop objects and assign in laptop variable.
            Product laptop = (Product) registry.lookup("laptop");

            String laptopName = laptop.getName();
            String laptopDescription = laptop.getDescription();
            double price = laptop.getPrice();

            System.out.println("The name of laptop is " + laptopName);
            System.out.println("The description of laptop is " + laptopDescription);
            System.out.println("The price of laptop is " + price);

        } catch (Exception e) {

            System.out.println("Exception in client side " + e);

        }

    }
}
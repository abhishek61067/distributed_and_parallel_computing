
import java.rmi.*;


public class ProductImpl implements Product {
    String name;
    String description;
    double price;

    ProductImpl(String newname,String newDescription, double newprice){
        // super();
        this.name=newname;
        this.description=newDescription;
        this.price=newprice;
    }
    
     public String getname() throws RemoteException{
        return this.name;

    }
     public String getdescription() throws RemoteException{
        return this.description;

    }
    public double getprice() throws RemoteException{
        return this.price;

    }

   public static void main(String[] args) {

   }
}

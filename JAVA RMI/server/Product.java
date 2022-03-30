
import java.rmi.*;

public interface Product extends Remote {
    // define product method/behaviour 
    public String getname() throws RemoteException;
    public double getprice()throws RemoteException;
    public String getdescription()throws RemoteException;
}

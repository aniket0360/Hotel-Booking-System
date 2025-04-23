package HotelBooking;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class HotelServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(2000); // Start RMI registry
            HotelInterface hotel = new HotelImplementation();
            Naming.rebind("HotelService", hotel);
            System.out.println("Hotel Booking Server is running...");
        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}

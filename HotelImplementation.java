package HotelBooking;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class HotelImplementation extends UnicastRemoteObject implements HotelInterface {
    private Map<String, String> bookings;

    protected HotelImplementation() throws RemoteException {
        bookings = new HashMap<>();
    }

    @Override
    public synchronized String bookRoom(String guestName) throws RemoteException {
        if (bookings.containsKey(guestName)) {
            return "Guest " + guestName + " already has a booking.";
        }
        bookings.put(guestName, "Room#" + (bookings.size() + 1));
        return "Room booked for " + guestName;
    }

    @Override
    public synchronized String cancelBooking(String guestName) throws RemoteException {
        if (!bookings.containsKey(guestName)) {
            return "No booking found for " + guestName;
        }
        bookings.remove(guestName);
        return "Booking cancelled for " + guestName;
    }
}

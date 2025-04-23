package HotelBooking;

import java.rmi.Naming;
import java.util.Scanner;

public class HotelClient {
    public static void main(String[] args) {
        try {
            HotelInterface hotel = (HotelInterface) Naming.lookup("rmi://localhost/HotelService");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n1. Book Room");
                System.out.println("2. Cancel Booking");
                System.out.println("3. Exit");
                System.out.print("Choose: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter guest name to book room: ");
                        String guestToBook = scanner.nextLine();
                        System.out.println(hotel.bookRoom(guestToBook));
                        break;
                    case 2:
                        System.out.print("Enter guest name to cancel booking: ");
                        String guestToCancel = scanner.nextLine();
                        System.out.println(hotel.cancelBooking(guestToCancel));
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}

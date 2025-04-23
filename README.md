# Hotel-Booking-System

Project Structure
You'll have the following files:

HotelBooking/
│
├── HotelInterface.java       // RMI Interface
├── HotelImplementation.java  // RMI Server implementation
├── HotelServer.java          // RMI Server runner
└── HotelClient.java          // RMI Client

Run following commands serially:
1. `javac -source 11 -target 11 HotelBooking/*.java`
2. `start rmiregistry`
3. `java HotelBooking.HotelServer`
4. `java HotelBooking.HotelClient`

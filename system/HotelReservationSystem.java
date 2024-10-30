package hotel.system;

import java.time.LocalDate;
import java.util.*;

public class HotelReservationSystem {
    private List<Room> rooms = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();

    public HotelReservationSystem() {
        // Add some initial rooms
        rooms.add(new Room(101, RoomType.SINGLE, 100));
        rooms.add(new Room(102, RoomType.DOUBLE, 150));
        rooms.add(new Room(103, RoomType.SUITE, 300));
    }

    public List<Room> searchRooms(RoomType type) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getType() == type && room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public Reservation makeReservation(String customerName, RoomType type, LocalDate checkIn, LocalDate checkOut) {
        List<Room> availableRooms = searchRooms(type);
        if (availableRooms.isEmpty()) {
            System.out.println("No available rooms of type " + type);
            return null;
        }

        Room room = availableRooms.get(0); // Choose the first available room
        double amount = room.getPrice();

        if (Payment.processPayment(customerName, amount)) {
            Reservation reservation = new Reservation(room, customerName, checkIn, checkOut);
            reservations.add(reservation);
            System.out.println("Reservation successful: " + reservation);
            return reservation;
        } else {
            System.out.println("Payment failed. Reservation not completed.");
            return null;
        }
    }

    public void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
            return;
        }
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    public static void main(String[] args) {
        HotelReservationSystem hotel = new HotelReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Hotel Reservation System");
            System.out.println("1. Search for Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter room type (SINGLE, DOUBLE, SUITE): ");
                    RoomType type = RoomType.valueOf(scanner.nextLine().toUpperCase());
                    List<Room> availableRooms = hotel.searchRooms(type);
                    if (availableRooms.isEmpty()) {
                        System.out.println("No available rooms of type " + type);
                    } else {
                        System.out.println("Available rooms:");
                        for (Room room : availableRooms) {
                            System.out.println(room);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter room type (SINGLE, DOUBLE, SUITE): ");
                    type = RoomType.valueOf(scanner.nextLine().toUpperCase());
                    System.out.print("Enter check-in date (yyyy-mm-dd): ");
                    LocalDate checkIn = LocalDate.parse(scanner.nextLine());
                    System.out.print("Enter check-out date (yyyy-mm-dd): ");
                    LocalDate checkOut = LocalDate.parse(scanner.nextLine());

                    hotel.makeReservation(customerName, type, checkIn, checkOut);
                    break;

                case 3:
                    hotel.viewReservations();
                    break;

                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}

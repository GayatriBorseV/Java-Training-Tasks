import java.util.ArrayList;
import java.util.Scanner;

// Room Class
class Room {
    private int roomNumber;
    private String roomType;
    private boolean isAvailable;
    private double pricePerNight;

    // Constructor
    public Room(int roomNumber, String roomType, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isAvailable = true; // Room is available by default
        this.pricePerNight = pricePerNight;
    }

    // Getters
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    // Setters
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Display room details
    public void displayRoomDetails() {
        System.out.println("Room Number: " + roomNumber + ", Type: " + roomType + 
                ", Available: " + (isAvailable ? "Yes" : "No") + ", Price/Night: $" + pricePerNight);
    }
}

// Hotel Class
class Hotel {
    private ArrayList<Room> rooms;

    // Constructor
    public Hotel() {
        rooms = new ArrayList<>();
    }

    // Add a room to the hotel
    public void addRoom(Room room) {
        rooms.add(room);
    }

    // Check room availability
    public Room checkAvailability(String roomType) {
        for (Room room : rooms) {
            if (room.isAvailable() && room.getRoomType().equalsIgnoreCase(roomType)) {
                return room; // Return the first available room of the requested type
            }
        }
        return null; // No available room of the requested type
    }

    // Book a room
    public boolean bookRoom(int roomNumber, int nights) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                room.setAvailable(false); // Mark the room as booked
                System.out.println("Room " + roomNumber + " booked successfully for " + nights + " nights.");
                double totalCharge = calculateTotalCharges(room, nights);
                System.out.println("Total Charges: " + totalCharge);
                return true;
            }
        }
        System.out.println("Room not available or invalid room number!");
        return false;
    }

    // Calculate total charges based on number of nights
    public double calculateTotalCharges(Room room, int nights) {
        return room.getPricePerNight() * nights;
    }

    // Display all room details
    public void displayRooms() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms available in the hotel.");
        } else {
            System.out.println("Room Details:");
            for (Room room : rooms) {
                room.displayRoomDetails();
            }
        }
    }
}

// Main Class
public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        // Adding some rooms to the hotel
        hotel.addRoom(new Room(101, "Single", 100));
        hotel.addRoom(new Room(102, "Double", 150));
        hotel.addRoom(new Room(103, "Suite", 300));

        boolean running = true;

        System.out.println("Welcome to the Hotel Reservation System!");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. View Rooms");
            System.out.println("2. Check Room Availability");
            System.out.println("3. Book a Room");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: // View Rooms
                    hotel.displayRooms();
                    break;

                case 2: // Check Room Availability
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter room type (Single/Double/Suite): ");
                    String roomType = scanner.nextLine();
                    Room availableRoom = hotel.checkAvailability(roomType);
                    if (availableRoom != null) {
                        System.out.println("Available Room:");
                        availableRoom.displayRoomDetails();
                    } else {
                        System.out.println("No rooms available for the requested type.");
                    }
                    break;

                case 3: // Book a Room
                    System.out.print("Enter room number to book: ");
                    int roomNumber = scanner.nextInt();
                    System.out.print("Enter number of nights: ");
                    int nights = scanner.nextInt();
                    hotel.bookRoom(roomNumber, nights);
                    break;

                case 4: // Exit
                    System.out.println("Thank you for using the Hotel Reservation System. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}

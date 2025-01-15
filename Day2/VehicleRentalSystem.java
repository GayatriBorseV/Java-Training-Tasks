import java.util.Scanner;

// Base Class
class Vehicle {
    private String vehicleType;
    private String numberPlate;
    private double rentalPricePerDay;

    // Constructor
    public Vehicle(String vehicleType, String numberPlate, double rentalPricePerDay) {
        this.vehicleType = vehicleType;
        this.numberPlate = numberPlate;
        this.rentalPricePerDay = rentalPricePerDay;
    }

    // Getters
    public String getVehicleType() {
        return vehicleType;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    // Calculate total rental cost
    public double calculateRentalCost(int daysRented) {
        return rentalPricePerDay * daysRented;
    }

    // Display Vehicle Details
    public void displayDetails() {
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Number Plate: " + numberPlate);
        System.out.println("Rental Price Per Day: " + rentalPricePerDay);
    }
}

// Subclass: Car
class Car extends Vehicle {
    private int seatingCapacity;

    public Car(String numberPlate, double rentalPricePerDay, int seatingCapacity) {
        super("Car", numberPlate, rentalPricePerDay);
        this.seatingCapacity = seatingCapacity;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Seating Capacity: " + seatingCapacity);
    }
}

// Subclass: Bike
class Bike extends Vehicle {
    private boolean hasHelmet;

    public Bike(String numberPlate, double rentalPricePerDay, boolean hasHelmet) {
        super("Bike", numberPlate, rentalPricePerDay);
        this.hasHelmet = hasHelmet;
    }

    public boolean hasHelmet() {
        return hasHelmet;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Helmet Included: " + (hasHelmet ? "Yes" : "No"));
    }
}

// Subclass: Truck
class Truck extends Vehicle {
    private double loadCapacity; // in tons

    public Truck(String numberPlate, double rentalPricePerDay, double loadCapacity) {
        super("Truck", numberPlate, rentalPricePerDay);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

// Main Class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Vehicle Rental System");
        System.out.println("Select a vehicle type to rent:");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.println("3. Truck");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Vehicle vehicle = null;

        switch (choice) {
            case 1:
                System.out.print("Enter Car Number Plate: ");
                String carNumberPlate = scanner.nextLine();
                System.out.print("Enter Rental Price Per Day for Car: ");
                double carRentalPrice = scanner.nextDouble();
                System.out.print("Enter Seating Capacity: ");
                int seatingCapacity = scanner.nextInt();
                vehicle = new Car(carNumberPlate, carRentalPrice, seatingCapacity);
                break;

            case 2:
                System.out.print("Enter Bike Number Plate: ");
                String bikeNumberPlate = scanner.nextLine();
                System.out.print("Enter Rental Price Per Day for Bike: ");
                double bikeRentalPrice = scanner.nextDouble();
                System.out.print("Is Helmet Included? (true/false): ");
                boolean hasHelmet = scanner.nextBoolean();
                vehicle = new Bike(bikeNumberPlate, bikeRentalPrice, hasHelmet);
                break;

            case 3:
                System.out.print("Enter Truck Number Plate: ");
                String truckNumberPlate = scanner.nextLine();
                System.out.print("Enter Rental Price Per Day for Truck: ");
                double truckRentalPrice = scanner.nextDouble();
                System.out.print("Enter Load Capacity (in tons): ");
                double loadCapacity = scanner.nextDouble();
                vehicle = new Truck(truckNumberPlate, truckRentalPrice, loadCapacity);
                break;

            default:
                System.out.println("Invalid choice. Exiting...");
                System.exit(0);
        }

        // Ask for rental duration
        System.out.print("Enter the number of days to rent the vehicle: ");
        int daysRented = scanner.nextInt();

        // Display vehicle details and total rental cost
        System.out.println("\nVehicle Details:");
        if (vehicle != null) {
            vehicle.displayDetails();
            double totalCost = vehicle.calculateRentalCost(daysRented);
            System.out.println("Total Rental Cost for " + daysRented + " days: " + totalCost);
        }

        scanner.close();
    }
}

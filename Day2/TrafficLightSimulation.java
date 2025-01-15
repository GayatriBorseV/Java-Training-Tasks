import java.util.Scanner;

public class TrafficLightSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Traffic Light Simulation");
        System.out.println("Enter the light color (Red, Yellow, Green): ");
        String light = scanner.nextLine().trim().toLowerCase(); // Take input and normalize it

        switch (light) {
            case "red":
                System.out.println("Stop");
                break;
            case "yellow":
                System.out.println("Get Ready");
                break;
            case "green":
                System.out.println("Go");
                break;
            default:
                System.out.println("Invalid input! Please enter Red, Yellow, or Green.");
        }

        scanner.close();
    }
}

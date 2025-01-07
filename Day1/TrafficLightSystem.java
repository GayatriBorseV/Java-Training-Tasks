
import java.util.Scanner;

public class TrafficLightSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter traffic light color (green, yellow, red): ");
        String light = scanner.next().toLowerCase();
        System.out.println("Is there an obstacle? (true/false): ");
        boolean obstacle = scanner.nextBoolean();

        if (obstacle) {
            System.out.println("Do not move.");
        } else {
            switch (light) {
                case "green":
                    System.out.println("Go.");
                    break;
                case "yellow":
                    System.out.println("Slow Down.");
                    break;
                case "red":
                    System.out.println("Stop.");
                    break;
                default:
                    System.out.println("Invalid color.");
            }
        }
        scanner.close();
    }
}

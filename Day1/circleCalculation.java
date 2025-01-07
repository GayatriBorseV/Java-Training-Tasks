import java.util.Scanner;

public class circleCalculation{ 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();
        System.out.println("Circumference: " + (2 * Math.PI * radius));
        System.out.println("Area: " + (Math.PI * radius * radius));
        scanner.close();
    }
}
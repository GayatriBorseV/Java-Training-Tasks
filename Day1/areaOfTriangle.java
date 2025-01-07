import java.util.*;
public class areaOfTriangle{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the base and height of the triangle: ");
        double base = scanner.nextDouble();
        double height = scanner.nextDouble();
        System.out.println("Area of Triangle: " + (0.5 * base * height));
        scanner.close();
    }
}

import java.util.Scanner;

public class temperatureConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        System.out.println("Fahrenheit: " + (celsius * 9 / 5 + 32));

        System.out.println("Enter temperature in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();
        System.out.println("Celsius: " + ((fahrenheit - 32) * 5 / 9));
        scanner.close();
    }
}

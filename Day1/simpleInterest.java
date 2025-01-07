
import java.util.Scanner;

public class simpleInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter principal, rate, and time: ");
        double principal = scanner.nextDouble();
        double rate = scanner.nextDouble();
        double time = scanner.nextDouble();
        System.out.println("Simple Interest: " + ((principal * rate * time) / 100));
        scanner.close();
    }
}


import java.util.Scanner;

// Find the remainder when the first number is divided by the second.

public class findRemainder{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number : ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second number : ");
        int num2 = scanner.nextInt();

        System.out.println("Remainder is : " + (num1%num2));
    }
}
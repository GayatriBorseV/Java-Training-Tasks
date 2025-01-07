import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        scanner.nextLine(); // Consume newline
        String inputString = scanner.nextLine();
        String reversedString = new StringBuilder(inputString).reverse().toString();
        if (inputString.equals(reversedString)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
        scanner.close();
    }
}
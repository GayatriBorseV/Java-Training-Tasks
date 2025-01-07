
import java.util.*;

public class passwordValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a password: ");
        String password = scanner.next();
        if (password.length() >= 8 && password.matches(".*[a-zA-Z].*") && password.matches(".*\\d.*")) {
            System.out.println("Valid Password");
        } else {
            System.out.println("Invalid Password");
        }
        scanner.close();
    }
}

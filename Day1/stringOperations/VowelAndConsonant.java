
import java.util.Scanner;

public class VowelAndConsonant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = scanner.nextLine().toLowerCase();
        int vowels = 0, consonants = 0;
        for (char c : text.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                vowels++;
            } else if (Character.isLetter(c)) {
                consonants++;
            }
        }
        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
        scanner.close();
    }
}

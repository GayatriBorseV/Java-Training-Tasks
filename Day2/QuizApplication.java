import java.util.Scanner;

public class QuizApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Questions, options, and answers
        String[] questions = {
            "Which city is known as the IT hub of India?",
            "Which programming language is known as OOP-based?",
            "What is 5 + 3?",
            "Who is known as the Missile Man of India?"
        };

        String[][] options = {
            {"1. Hyderabad", "2. Bangalore", "3. Pune", "4. Mumbai"},
            {"1. Python", "2. HTML", "3. Java", "4. CSS"},
            {"1. 6", "2. 8", "3. 10", "4. 12"},
            {"1. A.P.J. Abdul Kalam", "2. C.V. Raman", "3. Homi Bhabha", "4. Vikram Sarabhai"}
        };

        int[] answers = {2, 3, 2, 1}; // Correct answer indices (1-based)

        int score = 0; // Initialize the user's score

        System.out.println("Welcome to the Quiz Application!");
        System.out.println("Answer the following questions:");

        // Loop through each question
        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQ" + (i + 1) + ". " + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }
            System.out.print("Your answer (1-4): ");
            int userAnswer = scanner.nextInt();

            // Check if the user's answer is correct
            if (userAnswer == answers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + options[i][answers[i] - 1]);
            }
        }

        // Display final score
        System.out.println("\nQuiz Completed!");
        System.out.println("Your score is: " + score + " out of " + questions.length);

        scanner.close();
    }
}

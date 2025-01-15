import java.util.Scanner;

public class OnlineExamTimer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Total time for the exam in minutes
        System.out.print("Enter the total exam time in minutes: ");
        int totalTime = scanner.nextInt();

        System.out.println("\nThe exam has started!");
        System.out.println("Time remaining will be displayed every minute.\n");

        // Countdown timer simulation
        while (totalTime > 0) {
            try {
                // Display the remaining time
                System.out.println("Time remaining: " + totalTime + " minute(s).");
                
                // Wait for 1 minute (simulated with a shorter time for demonstration)
                Thread.sleep(60000); // 60000 milliseconds = 1 minute
                
                // Decrease the remaining time by 1 minute
                totalTime--;
            } catch (InterruptedException e) {
                System.out.println("An error occurred in the timer.");
            }
        }

        // End of the exam
        System.out.println("\nTime is up! The exam has ended.");
        scanner.close();
    }
}

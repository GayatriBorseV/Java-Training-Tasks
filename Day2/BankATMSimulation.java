import java.util.Scanner;

public class BankATMSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 5000.00; // Initial balance
        boolean exit = false;

        System.out.println("Welcome to the ATM Simulation!");

        while (!exit) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Electricity Bill Calculation");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your current balance is: " + String.format("%.2f", balance));
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double deposit = scanner.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("Deposit successful! New balance: " + String.format("%.2f", balance));
                    } else {
                        System.out.println("Invalid amount! Please enter a positive value.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdraw = scanner.nextDouble();
                    if (withdraw > 0 && withdraw <= balance) {
                        balance -= withdraw;
                        System.out.println("Withdrawal successful! New balance: " + String.format("%.2f", balance));
                    } else if (withdraw > balance) {
                        System.out.println("Insufficient balance!");
                    } else {
                        System.out.println("Invalid amount! Please enter a positive value.");
                    }
                    break;
                case 4:
                    electricityBillCalculation(scanner);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM! Goodbye.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option! Please choose between 1 and 5.");
            }
        }
        scanner.close();
    }

    // Method for electricity bill calculation
    public static void electricityBillCalculation(Scanner scanner) {
        System.out.println("\nElectricity Bill Calculation:");
        System.out.print("Enter the number of units consumed: ");
        int units = scanner.nextInt();

        double bill = 0.0;

        // Calculate bill based on units consumed
        if (units <= 100) {
            bill = units * 1.5; // First 100 units at 1.5/unit
        } else if (units <= 200) {
            bill = 100 * 1.5 + (units - 100) * 2.5; // Next 100 units at 2.5/unit
        } else if (units <= 300) {
            bill = 100 * 1.5 + 100 * 2.5 + (units - 200) * 3.5; // Next 100 units at 3.5/unit
        } else {
            bill = 100 * 1.5 + 100 * 2.5 + 100 * 3.5 + (units - 300) * 5.0; // Above 300 units at 5.0/unit
        }

        System.out.println("Your electricity bill is: " + String.format("%.2f", bill));
    }
}
